package cn.hqweay.blog.controller;





import cn.hqweay.blog.dao.cache.RedisDao;
import cn.hqweay.blog.eamil.MailServiceImpl;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.mq.Sender;
import cn.hqweay.blog.service.interfaces.UserService;
import cn.hqweay.blog.utils.MD5;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.*;

/**
 * @description: TODO
 * Created by hqweay on 19-4-23 下午6:12
 */

@RestController
@RequestMapping("/api")
public class RegisterController {

  @Autowired
  private MailServiceImpl mailService;

  @Autowired
  private RedisDao redisDao;

  @Autowired
  private UserService userService;

  // 消息队列
  @Autowired
  private Sender sender;

  /**
   *
   * @description:  注册,发送注册邮件,交给消息队列处理
   * @param: [email, password]
   * @return: void 状态码 200
   */
  @ApiOperation(value = "注册", notes = "注册,验证码发送到邮箱.")
  @PostMapping(value = "/register")
  @ResponseStatus(HttpStatus.OK)
  public void register(@RequestParam("email") String email, @RequestParam("password") String password){
    // 实际通过消息队列来进行发送邮件的操作
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    sender.sendMail(user);
  }


  /**
   *  测试成功
   *
   * @description: 当用户点击了注册邮件中的链接后,开始真正的注册
   *               即 信息插入数据库
   * @param: [email, md5Code]
   * @return: java.lang.String 状态码 201
   */
  @ApiOperation(value = "用户点击邮箱注册链接", notes = "进行真实的注册")
  @GetMapping(value = "/register/{email}/that0s/cool/{md5Code}")
  @ResponseStatus(HttpStatus.CREATED)
  public String realRegister(@PathVariable("email") String email, @PathVariable("md5Code") String md5Code){
    // 验证 url 正确性
    if(md5Code.equals(MD5.getMd5Register(email))){
      // 验证成功
      String passMd5Code = redisDao.getUserPassMd5Code(email);

      if(passMd5Code!=null){

        // 重复注册判断
        if(userService.getUserByEmail(email) != null){
          return "注册失败,用户已存在.";
        }

        // 尝试注册
        userService.insertNormalUser(email, passMd5Code);
        return "注册成功,请返回登录";
      }else{
        // 返回 null
        // 注册失败 过一会重新注册
        return "注册失败,请等一会重试.";
      }// end register
    }else{
      // url 非法
      return "注册链接非法";
    }// end url verification
  }

}
