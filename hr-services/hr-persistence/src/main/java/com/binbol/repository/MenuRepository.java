package com.binbol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
	List<MenuEntity> findAllByStatus(int status);
}
