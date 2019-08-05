package cn.hqweay.blog.service.interfaces;

import cn.hqweay.blog.entity.Article;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-3-31 下午4:42
 */
public interface ArchiveService {
  /**
   * @description: TODO
   * @param: []
   * @return: java.util.ArrayList<cn.hqweay.blog.entity.Article>
   */
  ArrayList<Article> findArchivesByDay();
}
