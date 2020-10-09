package com.shpun.mapper;

import org.apache.ibatis.annotations.Param;

public interface StorageMapper {

    void decrease(@Param("productId") Integer productId, @Param("count") Integer count);

}