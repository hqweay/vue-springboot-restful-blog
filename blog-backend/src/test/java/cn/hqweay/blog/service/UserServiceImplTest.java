package cn.hqweay.blog.service;

import cn.hqweay.blog.BlogApplication;
import cn.hqweay.blog.BlogApplicationTests;
import cn.hqweay.blog.service.UserServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: TODO
 * Created by hqweay on 19-4-26 上午11:05
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = BlogApplication.class)
public class UserServiceImplTest extends BlogApplicationTests{

  @Autowired
  private UserServiceImpl userService;
  @Test
  public void Test(){

    System.out.println(222);
//    System.out.println(userService.getPermissionsByRole("ADMIN"));
  }

  @Test
  public void testGetEntFileList(){
    Assert.assertSame("企业数量不为10",10,userService.getPermissionsByRole("ADMIN"));
  }

}
