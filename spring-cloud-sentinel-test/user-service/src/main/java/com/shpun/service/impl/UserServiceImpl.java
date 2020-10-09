package com.shpun.service.impl;

import com.shpun.mapper.UserMapper;
import com.shpun.model.User;
import com.shpun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:35
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void deleteByPrimaryKey(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void insertSelective(User record) {
        userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<User> getByUserIdList(List<Integer> userIdList) {
        return userMapper.getByUserIdList(userIdList);
    }
}
