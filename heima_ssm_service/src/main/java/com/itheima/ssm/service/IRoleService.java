package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Role> findOtherRole(String id)throws Exception;

    Role findById(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
