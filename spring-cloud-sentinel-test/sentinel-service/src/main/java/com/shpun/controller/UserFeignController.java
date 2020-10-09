package com.shpun.controller;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/21 11:17
 */
@RequestMapping("/api/user")
@RestController
public class UserFeignController {

    @Autowired
    private UserFeignService userFeignService;

    @PostMapping("/add")
    public ResultVo<?> add(@RequestBody User user) {
        return userFeignService.add(user);
    }

    @GetMapping("/delete/{userId}")
    public ResultVo<?> delete(@PathVariable("userId") Integer userId) {
        return userFeignService.delete(userId);
    }

    @PostMapping("/update")
    public ResultVo<?> update(@RequestBody User user) {
        return userFeignService.update(user);
    }

    @GetMapping("/{userId}")
    public ResultVo<User> get(@PathVariable("userId") Integer userId) {
        return userFeignService.get(userId);
    }

}
