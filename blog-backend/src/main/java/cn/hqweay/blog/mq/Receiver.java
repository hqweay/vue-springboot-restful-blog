package cn.hqweay.blog.mq;

import cn.hqweay.blog.dao.cache.RedisDao;
import cn.hqweay.blog.eamil.MailServiceImpl;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.utils.MD5;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.server.UnicastServerRef;

/**
 * @description: RabbitListener 设置监听的队列
 * Created by hqweay on 19-5-23 上午11:21
 */
@Component
@RabbitListener(queues = "mailList")
public class Receiver {
  @Autowired
  private MailServiceImpl mailService;

  @Autowired
  private RedisDao redisDao;

  /**
   *
   * @description:  这里才是具体的发送注册邮件逻辑
   *                在消息队列处理
   * @param: [user]
   * @return: void
   */
  @RabbitHandler
  public void process(User user){
    String email = user.getEmail();
    String password = user.getPassword();

    // 给邮箱发送一个登录链接
    // 点击该链接后,才向数据库插入用户信息
    // 先把 email 和 密码(md5) 存入 redis
    // 发送一个 带有 email 以及根据 email+盐值 生成的 md5值 构造的 url 到邮箱
    // 点击 邮箱中该 url,先验证 email 与 md5
    // 再从 redis 取出 email 与 password 存入 数据库
    // 返回 注册成功/失败 信息

    //todo 判断是否

    // 注册链接 md5 Code
    String md5COde = MD5.getMd5Register(email);

    // 密码 md5
    String passMd5Code = MD5.getMd5ByPassword(password);

    if(redisDao.putUserInfo(email, passMd5Code)){
      // true 信息放入 redis 缓存
    }else {
      // false 失败
      // redis 出错
      // 或者 已经注册
    }

    // 生成注册链接
    String url = "http://etob.hqweay.cn:8080/blog-backend-1.0/api/register/"+ email + "/that0s/cool/" + md5COde;
    // 发送邮件
    mailService.sendTextMail(email, "确认注册邮件", "请在 10 分钟内点击链接确认注册 : " + url);
  }
}
