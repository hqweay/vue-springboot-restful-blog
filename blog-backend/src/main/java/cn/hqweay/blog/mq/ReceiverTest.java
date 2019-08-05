package cn.hqweay.blog.mq;

import cn.hqweay.blog.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * Created by hqweay on 19-5-23 下午1:31
 */

@Component
@RabbitListener(queues = "hello")
public class ReceiverTest {
  @RabbitHandler
  public void process(String msg){
    System.out.println("  哈哈  " + msg);
  }
}
