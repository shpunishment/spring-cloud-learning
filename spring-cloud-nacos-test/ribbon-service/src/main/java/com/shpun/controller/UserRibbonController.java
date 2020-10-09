package com.shpun.controller;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 14:51
 */
@RequestMapping("/api/user")
@RestController
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @PostMapping("/add")
    public ResultVo<?> add(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/api/user/add", user, ResultVo.class);
    }

    @GetMapping("/delete/{userId}")
    public ResultVo<?> delete(@PathVariable("userId") Integer userId) {
        return restTemplate.getForObject(userServiceUrl + "/api/user/delete/{0}", ResultVo.class, userId);
    }

    @PostMapping("/update")
    public ResultVo<?> update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/api/user/update", user, ResultVo.class);
    }

    @GetMapping("/{userId}")
    public ResultVo<?> get(@PathVariable("userId") Integer userId) {
        return restTemplate.getForObject(userServiceUrl + "/api/user/{0}", ResultVo.class, userId);
    }

}
