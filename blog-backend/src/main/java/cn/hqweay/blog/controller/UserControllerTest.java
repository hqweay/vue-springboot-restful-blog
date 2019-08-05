package cn.hqweay.blog.controller;

import cn.hqweay.blog.dto.ResponseBean;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.mq.Sender;
import cn.hqweay.blog.security.jwt.JWTUtil;
import cn.hqweay.blog.service.interfaces.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description: TODO
 * Created by hqweay on 19-4-1 上午11:27
 */
@RestController
public class UserControllerTest {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseBean login(@RequestParam("email") String email,
                            @RequestParam("password") String password) {
    User userBean = userService.getUserByEmail("email");
    if (userBean.getPassword().equals(password)) {
      ResponseBean responseBean = new ResponseBean();
      responseBean.setCode(200);
      responseBean.setMsg("ResponseBean success");
      responseBean.setData(JWTUtil.sign(email, password));
      return responseBean;
    } else {
//      throw new UnauthorizedException();
      throw new RuntimeException();
    }
  }

  @GetMapping("/article")
  public ResponseBean article() {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      return new ResponseBean(200, "You are already logged in", null);
    } else {
      return new ResponseBean(200, "You are guest", null);
    }
  }

  @GetMapping("/require_auth")
  @RequiresAuthentication
  public ResponseBean requireAuth() {
    return new ResponseBean(200, "You are authenticated", null);
  }

  @GetMapping("/require_role")
  @RequiresRoles("admin")
  public ResponseBean requireRole() {
    return new ResponseBean(200, "You are visiting require_role", null);
  }

  @GetMapping("/require_permission")
  @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
  public ResponseBean requirePermission() {
    return new ResponseBean(200, "You are visiting permission require edit,view", null);
  }

  @RequestMapping(path = "/401")
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ResponseBean unauthorized() {
    return new ResponseBean(401, "Unauthorized", null);
  }


  @Autowired
  private Sender sender;
  @RequestMapping(value = "/helloRabbit",method = RequestMethod.GET)
  public String sendMQ(){
    System.out.println("准备发送消息。。。");
    sender.send();
    return "success";
  }



}
