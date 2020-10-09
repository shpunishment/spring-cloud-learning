package com.shpun.controller;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:37
 */
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResultVo<?> add(@RequestBody User user) {
        userService.insertSelective(user);
        return ResultVo.ok();
    }

    @GetMapping("/delete/{userId}")
    public ResultVo<?> delete(@PathVariable("userId") Integer userId) {
        userService.deleteByPrimaryKey(userId);
        return ResultVo.ok();
    }

    @PostMapping("/update")
    public ResultVo<?> update(@RequestBody User user) {
        userService.updateByPrimaryKeySelective(user);
        return ResultVo.ok();
    }

    @GetMapping("/{userId}")
    public ResultVo<User> get(@PathVariable("userId") Integer userId) {
        User user = userService.selectByPrimaryKey(userId);
        return ResultVo.okData(user);
    }

}
