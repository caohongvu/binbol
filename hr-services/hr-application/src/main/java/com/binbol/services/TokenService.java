package com.binbol.services;

import com.binbol.entities.TokenEntity;

public interface TokenService {
    TokenEntity save(TokenEntity token);
    TokenEntity findByToken(String token);
    TokenEntity findByUsername(String ecoeUserId);
    
}
