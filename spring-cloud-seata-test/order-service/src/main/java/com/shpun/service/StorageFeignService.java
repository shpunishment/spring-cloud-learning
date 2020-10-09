package com.shpun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 16:20
 */
@FeignClient("storage-service")
public interface StorageFeignService {

    @GetMapping(value = "/api/storage/decrease")
    void decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);

}
