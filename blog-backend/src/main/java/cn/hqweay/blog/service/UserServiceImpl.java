package cn.hqweay.blog.service;

import cn.hqweay.blog.dao.UserMapper;
import cn.hqweay.blog.dao.UserRoleMapper;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.security.jwt.JWTUtil;
import cn.hqweay.blog.service.interfaces.UserService;
import com.example.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午3:34
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserRoleMapper userRoleMapper;

  @Override
  public User getUserByEmail(String email) {
    return userMapper.selectUserByEmail(email);
  }

  @Override
  public String getRoleByEmail(String email) {
    return userMapper.selectRoleByEmail(email);
  }


  @Override
  public ArrayList<String> getPermissionsByRole(String role) {
    return userMapper.selectPermissionsByRole(role);
  }

  @Override
  public void insertNormalUser(String email, String passMd5Code) {
    // 注册 用户
    userMapper.insertUser(email, passMd5Code);
    // 添加权限
    userRoleMapper.insertNormalUser(email);
  }

  @Override
  public String getEmailByToken(String token) {
    // token 无需验证了
    // token 有可能出错?
    // 返回 null 的情况
    return JWTUtil.getEmailByToken(token);
  }
}
