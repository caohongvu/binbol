package com.binbol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binbol.entities.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
	TokenEntity findByUsername(String username);
	TokenEntity findByToken(String token);
	List<TokenEntity> findAllByStatus(Boolean status);
}
