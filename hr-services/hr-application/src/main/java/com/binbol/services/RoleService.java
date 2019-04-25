package com.binbol.services;

import java.util.List;

import com.binbol.dto.RoleDto;
import com.binbol.entities.RoleEntity;

public interface RoleService {
    
	List<RoleEntity> findAllByName(String username);
    
	RoleDto create(RoleDto role);
    
	RoleDto update(RoleDto role);
    
    RoleEntity findById(long id);
}
