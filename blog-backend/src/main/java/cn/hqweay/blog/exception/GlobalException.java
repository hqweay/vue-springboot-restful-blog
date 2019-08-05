package cn.hqweay.blog.exception;

import cn.hqweay.blog.enums.ErrorEnum;


public class GlobalException extends RuntimeException {

  private ErrorEnum errorEnum;

  public GlobalException(ErrorEnum errorEnum) {
    this.errorEnum = errorEnum;
  }

  public ErrorEnum getErrorEnum() {
    return errorEnum;
  }

  public void setErrorEnum(ErrorEnum errorEnum) {
    this.errorEnum = errorEnum;
  }
}
