package com.shpun.controller;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResultVo<User> get(@PathVariable("userId") Integer userId) throws Exception {
        User user = userService.selectByPrimaryKey(userId);
        if (user == null) {
            throw new NullPointerException();
        }
        return ResultVo.okData(user);
    }

    @GetMapping("/getByName")
    public ResultVo<List<User>> getByName(@RequestParam("name") String name) {
        List<User> userList = userService.searchByName(name);
        return ResultVo.okData(userList);
    }


}
