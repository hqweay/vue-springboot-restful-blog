package cn.hqweay.blog.controller.Article;

import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.ArticleImpl.ArticleServiceImpl;
import cn.hqweay.blog.service.ArticleImpl.UserArticleServiceImpl;
import cn.hqweay.blog.service.interfaces.Article.UserArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-25 下午4:58
 */
@RestController
@RequestMapping("/api/user")
public class UserArticleController {
  // 必须带上 token 验证
  @Autowired
  private UserArticleServiceImpl userArticleService;


  @ApiOperation(value = "按分页获取用户所有文章", notes = "用户获取自己的文章")
  @GetMapping(value = "/article")
  @ResponseStatus(HttpStatus.OK)
  public ArrayList<Article> getArticlesByPage(@PathVariable("email") String email,
          @RequestParam(value = "pageNum", required = true, defaultValue = "0") int pageNum,
          @RequestParam(value = "pageSize", required = true, defaultValue = "5") int pageSize) {

    //todo 验证 token
    //     通过 token 中的用户信息 获取自己的 文章
    return userArticleService.findAllArticles(email, pageNum, pageSize);
  }

}
