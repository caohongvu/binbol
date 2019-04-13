package com.binbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.dto.MenuDto;
import com.binbol.dto.RoleMenuPermissionDto;
import com.binbol.entities.RoleMenuPermissionEntity;
import com.binbol.repository.RoleMenuPermissionRepository;
import com.binbol.services.RoleMenuPermissionService;
import com.binbol.services.cache.MenuCache;

@Service
public class RoleMenuPermissionServiceImpl implements RoleMenuPermissionService {

	
	@Autowired
	RoleMenuPermissionRepository roleMenuPermissionRepository;

	@Autowired
	private MenuCache menuCache;
	
	ModelMapper mapper;
	
	@Override
	public List<RoleMenuPermissionDto> findAllByRole(int roleId) {
		List<RoleMenuPermissionEntity> entities = roleMenuPermissionRepository.findAllByRole(roleId);
		return this.map(entities);
	}
	
	private List<RoleMenuPermissionDto> map(List<RoleMenuPermissionEntity> entities) {
		List<RoleMenuPermissionDto> rtn = new ArrayList<>();
		entities.stream().map((entity) -> {
			RoleMenuPermissionDto dto = new RoleMenuPermissionDto();
			mapper.map(entity, dto);
			MenuDto menu = menuCache.get(entity.getMenu());
			if(menu != null) {
				dto.setDescription(menu.getDescription());
				dto.setIconclass(menu.getIconclass());
				dto.setMenuLabel(menu.getName());
				dto.setPosition(menu.getPosition());
				dto.setUrl(menu.getUrl());
			}
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
