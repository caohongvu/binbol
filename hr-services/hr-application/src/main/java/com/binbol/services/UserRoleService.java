package com.binbol.services;

import java.util.List;

import com.binbol.dto.UserRoleDto;

public interface UserRoleService {
    List<UserRoleDto> findAllByUsername(String username);
}
