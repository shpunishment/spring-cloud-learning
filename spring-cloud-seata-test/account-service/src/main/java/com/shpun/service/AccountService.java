package com.shpun.service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 15:40
 */
public interface AccountService {

    /**
     * 扣减用户余额
     * @param userId
     * @param money
     */
    void decrease(Integer userId, BigDecimal money);

}
