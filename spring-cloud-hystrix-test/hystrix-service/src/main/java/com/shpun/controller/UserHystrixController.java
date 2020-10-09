package com.shpun.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserRibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;


/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 17:15
 */
@RequestMapping("/api/user")
@RestController
public class UserHystrixController {

    private static final Logger logger = LoggerFactory.getLogger(UserHystrixController.class);

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

    @GetMapping("/cache/{userId}")
    public ResultVo<?> cache(@PathVariable("userId") Integer userId) {
        userRibbonService.getForTestCache(userId);
        userRibbonService.getForTestCache(userId);
        return userRibbonService.getForTestCache(userId);
    }

    @GetMapping("/removeCache/{userId}")
    public ResultVo<?> removeCache(@PathVariable("userId") Integer userId) {
        userRibbonService.getForTestCache(userId);
        userRibbonService.deleteForRemoveCache(userId);
        return userRibbonService.getForTestCache(userId);
    }

    @GetMapping("/collapser")
    public void getForTestCollapser() throws Exception {
        Future<User> future1 = userRibbonService.getForTestCollapser(1);
        Future<User> future2 = userRibbonService.getForTestCollapser(2);
        logger.info("getForTestCollapser future1: " + future1.get());
        logger.info("getForTestCollapser future2: " + future2.get());

        ThreadUtil.safeSleep(200);
        Future<User> future3 = userRibbonService.getForTestCollapser(3);
        logger.info("getForTestCollapser future3: " + future3.get());
    }

}
