package com.binbol.controllers;


import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binbol.dto.RoleDto;
import com.binbol.dto.UserAccountDto;
import com.binbol.exception.BinbolRuntimeException;
import com.binbol.services.RoleService;
import com.binbol.services.UserAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/role")
@Api("APIs about role")
public class RoleController {

    @Autowired
    RoleService roleService;
    
    @GetMapping(value = "/")
    public ResponseEntity<RoleDto> findAllRoles() {
    	return null;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<RoleDto> createNewRole(@RequestBody RoleDto roleDto) {
    	try {
    		RoleDto result = roleService.create(roleDto);		
    		return new ResponseEntity<>(result, HttpStatus.OK);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    }

    @PostMapping(value = "/update")
    public ResponseEntity<RoleDto> editUser(@RequestBody RoleDto roleDto) {
        try {
        	RoleDto result = roleService.update(roleDto);		
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    
    
}
