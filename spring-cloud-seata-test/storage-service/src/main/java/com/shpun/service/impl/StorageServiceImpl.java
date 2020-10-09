package com.shpun.service.impl;

import com.shpun.mapper.StorageMapper;
import com.shpun.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/30 16:18
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Integer productId, Integer count) {
        storageMapper.decrease(productId, count);
    }
}
