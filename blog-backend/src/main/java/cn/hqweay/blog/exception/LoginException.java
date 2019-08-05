package cn.hqweay.blog.exception;

import cn.hqweay.blog.enums.ErrorEnum;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午4:30
 */

public class LoginException extends GlobalException {


  public LoginException(ErrorEnum errorEnum) {
    super(errorEnum);
  }
}
