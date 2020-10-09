package com.shpun.mapper;

import com.shpun.model.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    List<User> searchByName(String name);

}