package com.binbol.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.dto.RoleDto;
import com.binbol.entities.RoleEntity;
import com.binbol.repository.RoleRepository;
import com.binbol.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<RoleEntity> findAllByName(String username) {
		List<RoleEntity> roles = roleRepository.findAllByName(username);
		return roles;
	}
	
	@Override
	public RoleDto create(RoleDto role) {
		return null;
	}

	@Override
	public RoleDto update(RoleDto role) {
		return null;
	}

	@Override
	public RoleEntity findById(long id) {
		return null;
	}

}
