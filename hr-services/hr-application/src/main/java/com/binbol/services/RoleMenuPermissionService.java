package com.binbol.services;

import java.util.List;

import com.binbol.dto.RoleMenuPermissionDto;

public interface RoleMenuPermissionService {
    List<RoleMenuPermissionDto> findAllByRole(int roleId);
}
