package cn.hqweay.blog.service.ArticleImpl;

import cn.hqweay.blog.dao.ArticleMapper;
import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.interfaces.Article.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-3-30 下午4:17
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public ArrayList<Article> findAllArticles() {

    return articleMapper.selectAllArticles();
  }

  @Override
  public ArrayList<Article> findArticlesByPage(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    return articleMapper.selectAllArticles();

  }


  @Override
  public Article findArticleById(long id) {
    return articleMapper.selectArticleById(id);
  }

  @Override
  public void deleteArticleById(long id) {
    articleMapper.deleteArticleById(id);
  }

  @Override
  public void insertArticle(Article article) {
    articleMapper.insertArticle(article);
  }

  @Override
  public void updateArticle(Article article) {
    articleMapper.updateArticle(article);
  }
}
