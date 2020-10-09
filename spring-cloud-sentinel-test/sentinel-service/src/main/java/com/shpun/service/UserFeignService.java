package com.shpun.service;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.fallback.UserFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/28 14:48
 */
@FeignClient(value = "user-service", fallback = UserFeignServiceFallback.class)
public interface UserFeignService {

    @PostMapping("/api/user/add")
    ResultVo<?> add(@RequestBody User user);

    @GetMapping("/api/user/delete/{userId}")
    ResultVo<?> delete(@PathVariable("userId") Integer userId);

    @PostMapping("/api/user/update")
    ResultVo<?> update(@RequestBody User user);

    @GetMapping("/api/user/{userId}")
    ResultVo<User> get(@PathVariable("userId") Integer userId);

}
