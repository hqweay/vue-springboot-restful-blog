package cn.hqweay.blog.mq;

import cn.hqweay.blog.dao.cache.RedisDao;
import cn.hqweay.blog.eamil.MailServiceImpl;
import cn.hqweay.blog.entity.User;
import cn.hqweay.blog.utils.MD5;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: TODO
 * Created by hqweay on 19-5-23 上午11:19
 */
@Component
public class Sender {

  //注入 AmqpTemplate，然后利用AmqpTemplate向一个名为hello的消息队列中发送消息。
  @Autowired
  private AmqpTemplate rabbitTemplate;

  /**
   *
   * @description: 消息队列发送注册邮件
   * @param: [email, password]
   * @return: void
   */
  public void sendMail(User user){
    // 第一个参数指定发送到哪个队列
    this.rabbitTemplate.convertAndSend("mailList", user);
  }

  public void send(){
    String msg="hello rabbitMQ:"+new Date()+" 你好，高级消息队列使用ing~";
    System.out.println("单对单发送参数。Sender发出了消息:"+msg);
    this.rabbitTemplate.convertAndSend("hello", msg);
    // 第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息,Topic方式
    // this.rabbitTemplate.convertAndSend("topicExchange","key.da",msg);
  }
}
