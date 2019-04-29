package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        role.setId(UUIDUtils.getUUID());
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(String id) throws Exception {
        return roleDao.findOtherRole(id);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permission:permissionIds){
            roleDao.addPermissionToRole(roleId,permission);
        }
    }
}
