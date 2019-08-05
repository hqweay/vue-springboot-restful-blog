package cn.hqweay.blog.service.ArticleImpl;

import cn.hqweay.blog.dao.ArticleMapper;
import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.interfaces.Article.UserArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-25 下午5:12
 */
@Service
public class UserArticleServiceImpl implements UserArticleService {
  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public ArrayList<Article> findAllArticles(String email, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    return articleMapper.selectArticlesByEmail(email);
  }


}
