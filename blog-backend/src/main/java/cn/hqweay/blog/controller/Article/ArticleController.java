package cn.hqweay.blog.controller.Article;

import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.ArticleImpl.ArticleServiceImpl;
import cn.hqweay.blog.service.interfaces.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * todo : 不做复杂了
 *        这个类 当作 管理员的 后台类吧
 *        通过这个 api 进行 增删改 只能管理员操作
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

  @Autowired
  private ArticleServiceImpl articleService;
  @Autowired
  private UserService userService;

// 获取所有文章,谁都可以
  @ApiOperation(value = "按分页所有获取文章", notes = "用户,游客都可以调用")
  @GetMapping(value = "/article")
  @ResponseStatus(HttpStatus.OK)
  public ArrayList<Article> getArticlesByPage(@RequestParam(value = "pageNum", required = true, defaultValue = "0") int pageNum,
                                              @RequestParam(value = "pageSize", required = true, defaultValue = "5") int pageSize) {
    return articleService.findArticlesByPage(pageNum, pageSize);
  }

  @ApiOperation(value = "通过 id 获取文章", notes = "用户,游客都可以调用")
  @GetMapping(value = "/article/id")
  @ResponseStatus(HttpStatus.OK)
  public Article getArticleById(@RequestParam(value = "id") long id) {
    return articleService.findArticleById(id);
  }



// todo 通过 token 判断,或者是管理员权限,直接删除!!!

  @ApiOperation(value = "添加 文章", notes = "所有用户都可以调用")
  @PostMapping(value = "/article/create")
  @ResponseStatus(HttpStatus.CREATED)
//  @RequiresRoles("ADMIN")  首先要有用户的权限,或者 create 权限
  public void addArticle(@RequestHeader ("Authorization") String token, @RequestBody Article article) {
    //todo 再通过 token 判断 文章信息的 user 与 token 中 user 是否符合
    String email = userService.getEmailByToken(token);

    // 判断 email 与 article 的 作者 的 email 是否一致

    articleService.insertArticle(article);
  }


  // 管理员有权删所有文章??? no
  // 每个人都只能删自己的文章
  @ApiOperation(value = "根据 id 删除文章", notes = "每个人都只能删除自己的文章")
  @DeleteMapping(value = "/article/delete/id")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  //    @RequiresPermissions(logical = Logical.AND, value = {"delete"}) 首先要有用户的权限,或者 delete 权限
  public void deleteUser(@RequestParam(value = "id") long id) {
    //todo token 判断
    articleService.deleteArticleById(id);
  }

  @ApiOperation(value = "更新文章", notes = "每个人只能更新自己的文章")
  @PatchMapping(value = "/article/update")
  @ResponseStatus(HttpStatus.CREATED)
  //    @RequiresPermissions(logical = Logical.AND, value = {"edit"}) 权限
  public void updateArticle(@RequestBody Article article) {

    //todo token 判断
    articleService.updateArticle(article);
  }

}
