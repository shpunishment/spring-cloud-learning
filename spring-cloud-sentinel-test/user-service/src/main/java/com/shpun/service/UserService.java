package com.shpun.service;

import com.shpun.model.User;

import java.util.List;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:35
 */
public interface UserService {

    void deleteByPrimaryKey(Integer userId);

    void insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    void updateByPrimaryKeySelective(User record);

    List<User> getByUserIdList(List<Integer> userIdList);

}
