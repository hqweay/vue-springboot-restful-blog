package cn.hqweay.blog.security.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 上午11:25
 */
public class JWTToken implements AuthenticationToken {

  // 密钥
  private String token;

  public JWTToken(String token) {
    this.token = token;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}

