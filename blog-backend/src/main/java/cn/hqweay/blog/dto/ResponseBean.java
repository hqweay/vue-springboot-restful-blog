package cn.hqweay.blog.dto;

import lombok.Data;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午12:13
 */
@Data
public class ResponseBean<T> {
  // http 状态码
  private int code;

  // 返回信息
  private String msg;

  // 返回的数据
  private T data;

  public ResponseBean() {}

  public ResponseBean(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

}
