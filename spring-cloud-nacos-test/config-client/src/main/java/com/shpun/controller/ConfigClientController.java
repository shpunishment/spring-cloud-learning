package com.shpun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/21 16:57
 */
// 用于刷新配置
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${user-service.info}")
    private String info;

    @GetMapping("/info")
    public String getInfo() {
        return info;
    }

}

