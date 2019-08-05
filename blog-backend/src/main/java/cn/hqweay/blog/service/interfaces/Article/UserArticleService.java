package cn.hqweay.blog.service.interfaces.Article;

import cn.hqweay.blog.entity.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-4-25 下午5:10
 */
@Service
public interface UserArticleService {
  /**
   * @description: 分页获取 User 所有文章
   * @param: []
   * @return: java.util.ArrayList<com.example.entity.Article>
   */
  ArrayList<Article> findAllArticles(String email, int pageNum, int pageSize);

}
