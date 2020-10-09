package com.shpun.controller;

import com.shpun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:45
 */
@RequestMapping("/api/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/decrease")
    public void decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money) {
//        int i = 10/0;
        accountService.decrease(userId,money);
    }

}
