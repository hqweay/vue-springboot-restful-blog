package cn.hqweay.blog.security.shiro;

import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.security.jwt.JWTUtil;
import cn.hqweay.blog.service.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 该类实现 shiro 的授权,认证
 * 不过与 jwt 整合
 * 实际验证通过 token
 * Created by hqweay on 19-4-1 下午12:26
 */
@Service
public class MyRealm extends AuthorizingRealm {

//  private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

  @Autowired
  private UserServiceImpl userService;

//  @Autowired
//  public void setUserService(UserService userService) {
//    this.userService = userService;
//  }

  /**
   * 大坑！，必须重写此方法，不然Shiro会报错
   */
  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof JWTToken;
  }

  /**
   * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

    String email = JWTUtil.getEmailByToken(principals.toString());

    //    UserTest user = userService.getUser();
    User user = userService.getUserByEmail(email);
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    // user 获取 role
    String role = userService.getRoleByEmail(email);
    simpleAuthorizationInfo.addRole(role);

    // 权限判断
    // 根据 role 获取 permissions
    Set<String> permissions = new HashSet<>(userService.getPermissionsByRole(role));
    simpleAuthorizationInfo.addStringPermissions(permissions);
    //Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
    //simpleAuthorizationInfo.addStringPermissions(permission);
    return simpleAuthorizationInfo;
  }

  /**
   * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
   * 认证信息(身份验证)
   * Authentication 是用来验证用户身份
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
    String token = (String) auth.getCredentials();

    // 解密获得username，用于和数据库进行对比
    // 通过 jwt 的 token 获取 username
    String email = JWTUtil.getEmailByToken(token);
    if (email == null) {
      throw new AuthenticationException("token invalid");
    }

    // 根据 username 看后台是否能查到
    // UserTest userBean = userService.getUser(username);
    User user = userService.getUserByEmail(email);
    if (user == null) {
      throw new AuthenticationException("User didn't existed!");
    }

    // 验证 token
    if (!JWTUtil.verify(token, email, user.getPassword())) {
      throw new AuthenticationException("Username or password error");
    }

    return new SimpleAuthenticationInfo(token, token, "my_realm");
  }
}
