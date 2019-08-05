package cn.hqweay.blog.dto;


import cn.hqweay.blog.enums.ErrorEnum;
import cn.hqweay.blog.exception.GlobalException;

/***
 *
 * 错误处理返回数据类
 */
public class ErrorResult {
  // 自定义错误码
  private int code;
  // 错误信息
  private String error;

  public ErrorResult(String message, int code) {}

  public ErrorResult(GlobalException e) {
    this.code = e.getErrorEnum().getCode();
    this.error = e.getErrorEnum().getMessage();
  }

  public ErrorResult(ErrorEnum statusEnum) {
    this.code = statusEnum.getCode();
    this.error = statusEnum.getMessage();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return error;
  }

  public void setMessage(String message) {
    this.error = message;
  }
}
