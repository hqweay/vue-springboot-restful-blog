package cn.hqweay.blog.service.interfaces;

/**
 * @description: TODO
 * Created by hqweay on 19-4-23 下午8:11
 */
public interface RegisterService {

  /**
   *
   * @description: 通过邮箱地址生成一个 验证码
   * @param: []
   * @return: java.lang.String
   */
  String getVerificationCodeByEmail();

}
