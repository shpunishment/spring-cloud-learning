package com.shpun.service.impl;

import com.shpun.mapper.AccountMapper;
import com.shpun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:41
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void decrease(Integer userId, BigDecimal money) {
        accountMapper.decrease(userId, money);
    }

}
