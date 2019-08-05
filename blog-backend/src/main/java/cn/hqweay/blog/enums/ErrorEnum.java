package cn.hqweay.blog.enums;


public enum ErrorEnum {
  ALL_ERROR(404001, "this is first."),
  NEW_ERROR(404002, "this is second test."),

  SHIRO_ERROR(404100, "shiro error"),


  POST_ERROR(40400, "参数非法"),
  USER_NOT_FOUND(40401, "用户名或密码错误.");

  private int code;
  private String message;

  ErrorEnum() {
  }

  ErrorEnum(int state, String info) {
    this.code = state;
    this.message = info;
  }


  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }


}
