package cn.hqweay.blog.dao;

import com.example.entity.UserRoleKey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {

    /**
     *
     * @description: 普通用户
     * @param: [email]
     * @return: void
     */
    @Insert("insert into user_role(user_email, role_id) values(#{email}, 2)")
    void insertNormalUser(@Param("email")String email);
}