package com.binbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.dto.UserRoleDto;
import com.binbol.entities.UserRoleEntity;
import com.binbol.repository.UserRoleRepository;
import com.binbol.services.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	
	@Autowired
	UserRoleRepository userRoleRepository;

	ModelMapper mapper;
	
	@Override
	public List<UserRoleDto> findAllByUsername(String username) {
		List<UserRoleEntity> entities = userRoleRepository.findAllByUsername(username);
		return this.map(entities);
	}
	
	private List<UserRoleDto> map(List<UserRoleEntity> entities) {
		List<UserRoleDto> rtn = new ArrayList<>();
		entities.stream().map((entity) -> {
			UserRoleDto dto = new UserRoleDto();
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
