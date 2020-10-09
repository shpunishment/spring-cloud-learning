package com.shpun.service;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 16:17
 */
public interface StorageService {

    /**
     * 扣减商品库存
     * @param productId
     * @param count
     */
    void decrease(Integer productId, Integer count);

}
