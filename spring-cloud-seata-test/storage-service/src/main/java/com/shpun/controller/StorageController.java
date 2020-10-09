package com.shpun.controller;

import com.shpun.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 16:18
 */
@RequestMapping("/api/storage")
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/decrease")
    public void decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
    }

}
