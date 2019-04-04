package com.binbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
	
	UserAccountEntity findByUsername(String username);
    
}
