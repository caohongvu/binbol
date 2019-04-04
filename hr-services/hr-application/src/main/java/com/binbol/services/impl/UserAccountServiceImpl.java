package com.binbol.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.dto.UserAccountDto;
import com.binbol.entities.TokenEntity;
import com.binbol.entities.UserAccountEntity;
import com.binbol.exception.BinbolRuntimeException;
import com.binbol.message.EWSMessage;
import com.binbol.repository.UserAccountRepository;
import com.binbol.services.TokenService;
import com.binbol.services.UserAccountService;
import com.binbol.services.cache.TokenCache;
import com.binbol.util.JwtTokenDataObject;
import com.binbol.util.JwtUtilService;
import com.binbol.util.MD5Util;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	public static final int BROCKER_TYPE = 0;
	public static final int CLIENT_TYPE = 1;
	@Autowired
	JwtUtilService jwtUtilService;
	
	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private TokenCache tokenCache;


	ModelMapper mapper;


	@Override
	public UserAccountDto activeUser(UserAccountDto userAccountDto) {
		UserAccountEntity userAccount = new UserAccountEntity();
		mapper.map(userAccountDto, userAccount);
		userAccount.setIsActivated(true);
		userAccount.setIsBlocked(false);
		userAccount.setUpdatedDate(new Date());
		userAccountRepository.save(userAccount);
		mapper.map(userAccount, userAccountDto);
		return userAccountDto;
	}


	@Override
	public UserAccountDto login(String username, String password) {
			UserAccountEntity userAccountFrom = userAccountRepository.findByUsername(username);
			
			if(userAccountFrom != null && MD5Util.hash(password).equals(userAccountFrom.getPassword())){
				return generateTonkenWhenLoginSuccess(userAccountFrom);
			}
		
		throw new BinbolRuntimeException(EWSMessage.RESOURCE_NOT_FOUND);
	}

	@Override
	public UserAccountDto createUser(UserAccountDto userAccount) {
		UserAccountEntity entity = new UserAccountEntity();
		mapper.map(userAccount, entity);
		userAccountRepository.save(entity);
		mapper.map(entity, userAccount);
		return userAccount;
	}


	@Override
	public UserAccountDto update(UserAccountDto userAccountDTO) {
		Optional<UserAccountEntity> entity = userAccountRepository.findById(userAccountDTO.getId());
		if(entity == null || entity.get() == null) {
			return null;
		}
		mapper.map(userAccountDTO, entity.get());
		userAccountRepository.save( entity.get());
		mapper.map(entity.get(), userAccountDTO);
		return userAccountDTO;
	}


	@Override
	public UserAccountDto getUserByUsername(String username) {
		UserAccountEntity entity = userAccountRepository.findByUsername(username);
		UserAccountDto userAccount = new UserAccountDto();
		mapper.map(entity, userAccount);
		return userAccount;
	}
	
	private UserAccountDto generateTonkenWhenLoginSuccess(UserAccountEntity userAccount){
		String token;
		UserAccountDto userAccountDto = new UserAccountDto();
		if(userAccount.getIsActivated() == true) {
			JwtTokenDataObject jwtTokenDataObject = new JwtTokenDataObject();
			mapper.map(userAccount, jwtTokenDataObject);
			token = jwtUtilService.generateTokenLogin(jwtTokenDataObject);
			mapper.map(userAccount, userAccountDto);
			//create token record for management
			TokenEntity tokenEntity = tokenService.findByUsername(userAccount.getUsername());
			if(tokenEntity == null) {
				tokenEntity = new TokenEntity();
			} else {
				//remove older token in cache
				tokenCache.remove(tokenEntity.getToken());
			}
			
			tokenEntity.setUsername(userAccount.getUsername());
			tokenEntity.setToken(token);
			tokenEntity.setStatus(true);
			tokenService.save(tokenEntity);
			//put new token into token cache
			tokenCache.put(tokenEntity.getToken(), tokenEntity);
			//end token management
			
			return userAccountDto;
		}else throw new BinbolRuntimeException(EWSMessage.UNACTIVE);
	}

	private List<UserAccountDto> map(List<UserAccountEntity> userAccounts) {
		ArrayList<UserAccountDto> rtn = new ArrayList<>();
		userAccounts.stream().map((entity) -> {
			UserAccountDto dto = new UserAccountDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}

	@PostConstruct
	void init() {
		mapper = new ModelMapper();
	}
}
