package cn.hqweay.blog.service.interfaces;

import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.entity.User;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午3:33
 */
public interface UserService {

  /**
   * @description: 铜鼓昵称获取 user 对象
   * @param: [username]
   * @return: User
   */
  User getUserByEmail(String email);

  /**
   * @description: 根据 username 获取 role
   * 需要 联合 user_role role 表
   * @param: [username]
   * @return: java.lang.String
   */
  String getRoleByEmail(String email);

  /**
   *
   * @description: 根据 role 名 获取 权限列表
   * @param: [role]
   * @return: java.util.ArrayList<java.lang.String>
   */
  ArrayList<String> getPermissionsByRole(String role);

  /**
   *
   * @description: 用户 注册
   * @param: [email, passMd5Code]
   * @return: void
   */
  void insertNormalUser(String email, String passMd5Code);


  /**
   *
   * @description: 通过 token 获取 email
   * @param: [token]
   * @return: java.lang.String
   */
  String getEmailByToken(String token);
}