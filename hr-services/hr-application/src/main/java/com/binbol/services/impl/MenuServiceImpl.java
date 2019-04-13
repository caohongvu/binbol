package com.binbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.dto.MenuDto;
import com.binbol.entities.MenuEntity;
import com.binbol.repository.MenuRepository;
import com.binbol.services.MenuService;
import com.binbol.services.cache.MenuCache;

@Service
public class MenuServiceImpl implements MenuService {


	@Autowired
	private MenuRepository menuRepository;

	

	@Autowired
	private MenuCache menuCache;


	ModelMapper mapper;


	@Override
	public List<MenuDto> findAll() {
		List<MenuEntity> entities = menuRepository.findAllByStatus(1);
		return this.map(entities);
	}


	private List<MenuDto> map(List<MenuEntity> entities) {
		List<MenuDto> rtn = new ArrayList<>();
		entities.stream().map((entity) -> {
			MenuDto dto = new MenuDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}
	
	private void loadAllMenuToCache() {
		List<MenuDto> menus = findAll();
		menus.forEach(menu -> {
			menuCache.put(menu.getId(), menu);
		});
	}

	@PostConstruct
	void init() {
		mapper = new ModelMapper();
		loadAllMenuToCache();
	}
}
