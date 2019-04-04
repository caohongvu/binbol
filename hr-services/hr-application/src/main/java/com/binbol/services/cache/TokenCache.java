package com.binbol.services.cache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.binbol.entities.TokenEntity;

@Service
@Scope(value="singleton")
public class TokenCache extends ConcurrentHashMap<String, TokenEntity>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
