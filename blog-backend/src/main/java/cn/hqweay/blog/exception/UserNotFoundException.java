package cn.hqweay.blog.exception;

import cn.hqweay.blog.enums.ErrorEnum;

/**
 * @description: TODO
 * Created by hqweay on 19-3-29 下午10:51
 */
public class UserNotFoundException extends GlobalException {

  public UserNotFoundException(ErrorEnum errorEnum) {
    super(errorEnum);
  }


}
