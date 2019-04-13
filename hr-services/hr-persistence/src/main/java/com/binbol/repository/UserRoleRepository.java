package com.binbol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
	List<UserRoleEntity> findAllByUsername(String username);
}
