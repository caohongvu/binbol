package com.binbol.services.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.entities.TokenEntity;
import com.binbol.repository.TokenRepository;
import com.binbol.services.TokenService;
import com.binbol.services.cache.TokenCache;

@Service
public class TokenServiceImpl implements TokenService {

	
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	TokenCache tokenCache;
	
	@Override
	public TokenEntity save(TokenEntity token) {
		tokenRepository.save(token);
		return token;
	}

	@Override
	public TokenEntity findByToken(String token) {
		TokenEntity tokenEntity = tokenRepository.findByToken(token);
		return tokenEntity;
	}

	@Override
	public TokenEntity findByUsername(String ecoeUserId) {
		TokenEntity tokenEntity = tokenRepository.findByUsername(ecoeUserId);
		return tokenEntity;
	}
	
	@PostConstruct
	void init() {
		List<TokenEntity> entities = tokenRepository.findAllByStatus(true);
		entities.stream().forEach(entity->tokenCache.put(entity.getToken(), entity));
	}

}
