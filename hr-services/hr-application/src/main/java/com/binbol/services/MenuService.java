package com.binbol.services;

import java.util.List;

import com.binbol.dto.MenuDto;

public interface MenuService {
    List<MenuDto> findAll();
}
