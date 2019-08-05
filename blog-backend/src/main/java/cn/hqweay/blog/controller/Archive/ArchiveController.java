package cn.hqweay.blog.controller.Archive;

import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.ArchiveServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/** @description: TODO Created by hqweay on 19-3-31 下午4:40 */
@RestController
@RequestMapping("/api")
public class ArchiveController {
  // 所有 archive
  @Autowired
  private ArchiveServiceImpl archiveService;

  @ApiOperation(value = "按 Day 归档", notes = "按 Day 归档,获取所有文章归档信息.标题,日期,id")
  @GetMapping(value = "/archive/day")
  public ArrayList<Article> getArchivesByDay() {
    return archiveService.findArchivesByDay();
  }


}
