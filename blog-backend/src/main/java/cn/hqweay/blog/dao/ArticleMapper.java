package cn.hqweay.blog.dao;

import cn.hqweay.blog.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ArticleMapper {

  // 按创建日期降序 查询所有文章,与 pagehelper 搭配实现分页
  @Select("select * from article order by create_by desc")
  ArrayList<Article> selectAllArticles();

  // 根据 id 搜索文章
  @Select("select * from article where id = #{id}")
  Article selectArticleById(@Param("id") long id);

  // 根据 id 删除文章
  @Delete("delete from article where id = #{id}")
  void deleteArticleById(@Param("id") long id);

  // 添加文章
  @Insert("insert into article(title, tag, category, content,create_by) values(#{title}, #{tag}," +
          " #{category}, #{content}, NOW())")
  void insertArticle(Article article);

  // 更新文章
  @Update("update article set title = #{title},tag=#{tag},category=#{category},content=#{content} where id = #{id}")
  void updateArticle(Article article);

  // 按 用户 邮箱 查询所有文章, 按创建日期降序 与 pagehelper 搭配实现分页
  @Select(
          "select * from article, user_article where user_article.article_id = article.id\n"
                  + " and user_article.user_email = #{email} order by create_by desc")
  ArrayList<Article> selectArticlesByEmail(String email);

}
