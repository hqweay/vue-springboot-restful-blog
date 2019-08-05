package cn.hqweay.blog.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 上午11:25
 */
public class JWTUtil {

  // 过期时间 2 hrs
  private static final long EXPIRE_TIME = 120 * 60 * 1000;

  /**
   * 校验token是否正确
   *
   * @param token  密钥
   * @param secret 用户的密码
   * @return 是否正确
   */
  public static boolean verify(String token, String email, String secret) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
              .withClaim("email", email)
              .build();
      DecodedJWT jwt = verifier.verify(token);
      return true;
    } catch (Exception exception) {
      return false;
    }
  }

  /**
   * 获得token中的信息无需secret解密也能获得
   *
   * @return token 中包含的用户 邮箱
   */
  public static String getEmailByToken(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("email").asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

  /**
   * 生成签名,5min后过期
   *
   * @param email 用户邮箱 唯一
   * @param secret   用户的密码
   * @return 加密的token
   */
  public static String sign(String email, String secret) {
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    Algorithm algorithm = Algorithm.HMAC256(secret);
    // 附带username信息
    return JWT.create()
            .withClaim("email", email)
            .withExpiresAt(date)
            .sign(algorithm);
  }
}

