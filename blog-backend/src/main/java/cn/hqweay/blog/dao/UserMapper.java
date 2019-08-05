package cn.hqweay.blog.dao;

import cn.hqweay.blog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午3:30
 */
@Mapper
public interface UserMapper {

  // 通过 邮箱 获取用户信息
  @Select("select * from user where email = #{email}")
  User selectUserByEmail(@Param("email")String email);

  // 通过邮箱获取用户角色
  @Select("select role from role,user,user_role\n" +
          "where role.id = user_role.role_id and user_role.user_email = user.email and email = #{email}")
  String selectRoleByEmail(@Param("email")String email);

  // 通过角色获取用户权限
  @Select(
      "select permission from role_pemission left join permission on role_pemission.permission_id = permission.id\n"
          + "where role_pemission.role_id = (select id from role where role = #{role})")
  ArrayList<String> selectPermissionsByRole(@Param("role") String role);

  // 通过角色 id 获取权限
  // select permission from role_pemission left join permission on role_pemission.permission_id =
  // permission.id
  //  where role_pemission.role_id = "1";

  @Insert("insert into user(email, password, username) values( #{email}, #{password}, '无名用户')")
  void insertUser(@Param("email")String email, @Param("password")String passMd5Code);


}
