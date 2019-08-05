package cn.hqweay.blog.eamil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * Created by hqweay on 19-4-23 下午5:01
 */

@Service
public class MailServiceImpl implements MailService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private JavaMailSender mailSender;

  // 注入常量
  @Value("${mail.fromMail.addr}")
  private String from;

  /**
   * 发送文本邮件
   *
   * @param toAddr
   * @param title
   * @param content
   */
  @Override
  public void sendTextMail(String toAddr, String title, String content) {
    // 纯文本邮件对象
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(toAddr);
    message.setSubject(title);
    message.setText(content);

    try {
      mailSender.send(message);
      logger.info("Text邮件已经发送。");
    } catch (Exception e) {
      logger.error("发送Text邮件时发生异常！", e);
    }

  }

}

