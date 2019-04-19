package com.binbol.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.binbol.dto.UserAccountDto;
import com.binbol.entities.UserAccountEntity;
import com.binbol.exception.BinbolRuntimeException;
import com.binbol.services.UserAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
@Api("Tất cả các api liên quan đến User account")
public class UserController {

    @Autowired
    UserAccountService userService;

    public static final String ERR_CODE_ACTIVE = "ERR_ECOE_010";
   

    @PostMapping
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserAccountDto addNewUser(@RequestBody UserAccountDto userAccountDTO) {
        	UserAccountDto userAccountResponse = userService.createUser(userAccountDTO);
            return userAccountResponse;
    }


    @PostMapping
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<UserAccountDto> editUser(@RequestBody UserAccountDto userDTOParam) {
        try {
        	UserAccountDto userAccountDTO = userService.update(userDTOParam);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    
    @PostMapping
    @RequestMapping(value = "/active", method = RequestMethod.POST)
    @ApiOperation(value="Api dùng để active một tài khoản người dùng lần đầu tiên!")
    public ResponseEntity<UserAccountDto> activeUser(@RequestBody UserAccountDto userAccountDTO) {
        try {
        	UserAccountDto userAccountDTOResult = userService.activeUser(userAccountDTO);
            if (userAccountDTOResult == null) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            } else {
                return new ResponseEntity<>(userAccountDTOResult, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PermitAll
    public ResponseEntity<UserAccountDto> login(@RequestBody UserAccountDto loginRequest) {
        try {
            UserAccountDto userAccountDTOResult = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return new ResponseEntity<>(userAccountDTOResult, HttpStatus.OK);
        } catch (BinbolRuntimeException e){
            if((ERR_CODE_ACTIVE).equals(e.errorID)){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
            }else  {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }

    }
    
    @GetMapping(value = "/")
    @PermitAll
    public ResponseEntity<Page<UserAccountEntity>> findAll(
    		@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
    		@RequestParam(name = "size", required = false, defaultValue = "20") Integer size,
    		@RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
    	
    	Page<UserAccountEntity> result = null;
    	
    	Sort sortable = null;
    	if (sort.equals("DESC")) {
    		sortable = Sort.by("id").descending();
    	} else {
    		sortable = Sort.by("id").ascending();
    	}
    	
    	Pageable pageable = PageRequest.of(page, size, sortable);
    	
    	try {
    		result = userService.findAll(pageable);
    		return new ResponseEntity<>(result, HttpStatus.OK);
    	} catch (BinbolRuntimeException e) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    }
    
}
