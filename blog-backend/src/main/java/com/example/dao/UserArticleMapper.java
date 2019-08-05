package com.example.dao;

import com.example.entity.UserArticle;

public interface UserArticleMapper {
    int insert(UserArticle record);

    int insertSelective(UserArticle record);
}