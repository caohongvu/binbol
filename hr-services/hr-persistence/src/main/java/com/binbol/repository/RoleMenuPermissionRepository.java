package com.binbol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.RoleMenuPermissionEntity;

public interface RoleMenuPermissionRepository extends JpaRepository<RoleMenuPermissionEntity, Long> {
	List<RoleMenuPermissionEntity> findAllByRole(int role);
}
