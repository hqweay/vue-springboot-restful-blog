package com.example.dao;

import com.example.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}