package cn.hqweay.blog.dto;

import lombok.Data;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午3:18
 */
@Data
public class LoginResult {
  // http 状态码
  private int code;

  // 返回信息
  private String msg;

  // 返回 token
  private String token;
}
