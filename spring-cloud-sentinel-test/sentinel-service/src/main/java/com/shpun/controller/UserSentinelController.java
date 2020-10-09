package com.shpun.controller;

import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/28 14:19
 */
@RequestMapping("/api/user")
@RestController
public class UserSentinelController {

    @Autowired
    private UserRibbonService userRibbonService;

    @GetMapping("/fallback/{userId}")
    public ResultVo<?> fallback(@PathVariable("userId") Integer userId) {
        return userRibbonService.getForTestFallback(userId);
    }

    @GetMapping("/fallbackWithIgnore/{userId}")
    public ResultVo<?> fallbackWithIgnoreExceptions(@PathVariable("userId") Integer userId) {
        return userRibbonService.getForTestFallbackWithIgnoreExceptions(userId);
    }

}
