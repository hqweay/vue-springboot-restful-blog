package cn.hqweay.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启支持事务
@EnableTransactionManagement
@SpringBootApplication
public class BlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogApplication.class, args);
  }

}
