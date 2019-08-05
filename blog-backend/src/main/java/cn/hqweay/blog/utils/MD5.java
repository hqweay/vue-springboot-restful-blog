package cn.hqweay.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午4:47
 */
public class MD5 {

  public static String getMd5ByPassword(String password) {
    String base = password + "cao1cao0cao"; // + "/" + salt;
    return DigestUtils.md5DigestAsHex(base.getBytes());
  }

  public static String getMd5Code(String email){
    String base = email + "/" + "hell002oyo!";
    return DigestUtils.md5DigestAsHex(base.getBytes());
  }

  public static String getMd5Register(String value){
    String base = value + "/" + "hello0yo!";
    return DigestUtils.md5DigestAsHex(base.getBytes());
  }

}
