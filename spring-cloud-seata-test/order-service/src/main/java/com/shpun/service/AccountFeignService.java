package com.shpun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:59
 */
@FeignClient("account-service")
public interface AccountFeignService {

    @GetMapping("/api/account/decrease")
    void decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);

}
