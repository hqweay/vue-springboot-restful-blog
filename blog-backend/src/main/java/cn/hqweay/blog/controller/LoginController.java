package cn.hqweay.blog.controller;

import cn.hqweay.blog.dto.Token;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.enums.ErrorEnum;
import cn.hqweay.blog.exception.LoginException;
import cn.hqweay.blog.security.jwt.JWTUtil;
import cn.hqweay.blog.service.UserServiceImpl;
import cn.hqweay.blog.utils.MD5;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 下午3:08
 */
@RestController
@RequestMapping("/api")
public class LoginController {

  @Autowired
  private UserServiceImpl userService;

  @ApiOperation(value = "登录", notes = "登录,返回 token.")
  @PostMapping(value = "/login")
  @ResponseStatus(HttpStatus.OK)
  public Token login(@RequestParam("email") String email,
                     @RequestParam("password") String password) throws LoginException {

//     NotNull 绑定参数校验 用 RequestVaria
//    @PathVariable 是从一个URI模板里面来取值（/后面?之前）
//    @RequestParam 是从request里面取值（？之后）

    // 参数判断
    if (email.isEmpty() || password.isEmpty()) {
      throw new LoginException(ErrorEnum.POST_ERROR);
    }

    User user = userService.getUserByEmail(email);

    if (user.getPassword().equals(MD5.getMd5ByPassword(password))) {
//    登陆成功
      Token token = new Token();
      token.setToken(JWTUtil.sign(email, password));
      return token;

    } else {
//    失败
      throw new LoginException(ErrorEnum.USER_NOT_FOUND);
    }
  }
}
