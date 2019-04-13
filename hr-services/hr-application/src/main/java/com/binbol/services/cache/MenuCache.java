package com.binbol.services.cache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.binbol.dto.MenuDto;

@Service
@Scope(value="singleton")
public class MenuCache extends ConcurrentHashMap<Integer, MenuDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
