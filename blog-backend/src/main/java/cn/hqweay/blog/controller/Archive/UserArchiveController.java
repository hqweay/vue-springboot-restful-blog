package cn.hqweay.blog.controller.Archive;

import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.ArchiveServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-25 下午5:22
 */
@RestController
@RequestMapping("/api/user")
public class UserArchiveController {

  // 应该通过 token 获取

  // 按 user 分 archive
  @Autowired
  private ArchiveServiceImpl archiveService;

  @ApiOperation(value = "按 Day 归档", notes = "按 Day 归档")
  @GetMapping(value = "/archive/day")
  public ArrayList<Article> getArchivesByDay() {

    // 如果是 ADMIN 就获取所有
    // 如果是 普通用户,就获取自己的
    return archiveService.findArchivesByDay();
  }


}
