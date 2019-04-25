package com.binbol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	List<RoleEntity> findAllByName(String name);

}
