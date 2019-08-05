package cn.hqweay.blog.exception.ExceptionHander;

import cn.hqweay.blog.dto.ErrorResult;
import cn.hqweay.blog.exception.LoginException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: 拦截 Login 类 exception
 * 拦截 Login 相关错误
 * Created by hqweay on 19-3-29 下午10:56
 */
@ControllerAdvice
public class LoginExceptionHandler {

  @ExceptionHandler(value = LoginException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ErrorResult handleResourceNotFoundException(LoginException e) {
    return new ErrorResult(e.getErrorEnum());
  }
}
