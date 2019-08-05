package cn.hqweay.blog.dao;


import cn.hqweay.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-3-31 下午4:41
 */
@Mapper
public interface ArchiveMapper {
  /**
   *
   * @description: 按 日 查询 文章归档信息
   *               等于 查询 所有文章的归档信息
   *                归档信息 : 文章 id, 文章标题, 文章发布时间
   * @param: []
   * @return: java.util.ArrayList<cn.hqweay.blog.entity.Article>
   */
  @Select("select id, title, create_by from article order by create_by desc")
  ArrayList<Article> selectArchivesByDay();


}
