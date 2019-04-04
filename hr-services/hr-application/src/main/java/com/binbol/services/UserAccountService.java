package com.binbol.services;


import com.binbol.dto.UserAccountDto;



public interface UserAccountService {

   
    UserAccountDto createUser(UserAccountDto userAccount);
    UserAccountDto update(UserAccountDto userAccountDTO);
    UserAccountDto activeUser(UserAccountDto userAccountDTO);
    UserAccountDto getUserByUsername(String username);
    UserAccountDto login(String username, String password);
}