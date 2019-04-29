package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IRoleDao {
    @Select("SELECT r.* FROM role r ,users_role ur WHERE ur.roleId=r.id and ur.userId=#{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("SELECT * FROM role WHERE id NOT IN( SELECT roleId FROM users_role WHERE userId=#{id})")
    List<Role> findOtherRole(String id)throws Exception;

    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId)throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permission) throws Exception;
}
