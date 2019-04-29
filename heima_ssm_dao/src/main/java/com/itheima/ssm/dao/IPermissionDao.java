package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("SELECT p.* FROM permission p ,role_permission rp WHERE rp.permissionId=p.id AND rp.roleId=#{id}")
    List<Permission> findByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (id,permissionName,url) values(#{id},#{permissionName},#{url})")
    void save(Permission permission)throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleId) throws Exception;
}
