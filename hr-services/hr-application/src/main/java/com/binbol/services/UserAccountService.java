package com.binbol.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.binbol.dto.UserAccountDto;
import com.binbol.entities.UserAccountEntity;

public interface UserAccountService {

    UserAccountDto createUser(UserAccountDto userAccount);
    
    UserAccountDto update(UserAccountDto userAccountDTO);
    
    UserAccountDto activeUser(UserAccountDto userAccountDTO);
    
    UserAccountDto getUserByUsername(String username);
    
    UserAccountDto login(String username, String password);
    
    Page<UserAccountEntity> findAll(Pageable pageable);
}