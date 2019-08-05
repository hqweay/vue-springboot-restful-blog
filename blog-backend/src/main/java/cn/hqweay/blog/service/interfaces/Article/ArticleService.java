package cn.hqweay.blog.service.interfaces.Article;

import cn.hqweay.blog.entity.Article;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-3-30 下午4:09
 */
public interface ArticleService {
  /**
   * @description: 获取所有文章
   * @param: []
   * @return: java.util.ArrayList<com.example.entity.Article>
   */
  ArrayList<Article> findAllArticles();

  /**
   * @description: 通过分页获取文章
   * @param: []
   * @return: java.util.ArrayList<cn.hqweay.blog.entity.Article>
   */
  ArrayList<Article> findArticlesByPage(int pageNum, int pageSize);

  /**
   * @description: 根据 id 获取文章
   * @param: [id]
   * @return: cn.hqweay.blog.entity.Article
   */
  Article findArticleById(long id);

  /**
   * @description: 根据 id 删除文章
   * @param: [id]
   * @return: void
   */
  void deleteArticleById(long id);

  /**
   * @description: 新增文章
   * @param: []
   * @return: void
   */
  void insertArticle(Article article);

  /**
   * @description: 更新文章
   * @param: [article]
   * @return: void
   */
  void updateArticle(Article article);
}
