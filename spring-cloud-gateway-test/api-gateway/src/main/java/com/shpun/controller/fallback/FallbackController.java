package com.shpun.controller.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/24 9:52
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Object fallback() {
        Map<String,Object> result = new HashMap<>(2);
        result.put("code",500);
        result.put("message","服务调用异常");
        return result;
    }

}

