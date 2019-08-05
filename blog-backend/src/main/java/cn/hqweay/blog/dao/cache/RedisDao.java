package cn.hqweay.blog.dao.cache;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * @description: TODO
 * Created by hqweay on 1/1/19 2:28 PM
 */
@Component
public class RedisDao {

  @Autowired
  private RedisTemplate redisTemplate;

  // 注册信息过期时间
  private int loginInfoTimeOu = 600;

  // 用户信息缓存到 redis
  // 如果用户确认邮箱中链接,再取出来,存入数据库
  public boolean putUserInfo(String email, String md5Code) {
    if (redisTemplate.hasKey(email)) {
      return false;
    } else {
      // 10 分钟后过期
      redisTemplate.opsForValue().set(email, md5Code, this.loginInfoTimeOu, TimeUnit.SECONDS);
    }
    return true;
  }

  public String getUserPassMd5Code(String email){
    if (redisTemplate.hasKey(email)){
      // 还不确定返回啥
      // 期望返回 对应 eamil 的 md5 password
      return String.valueOf(redisTemplate.opsForValue().get(email));

    }else{
      // 没有
      return null;
    }
  }




}
