package com.shpun.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountMapper {

    void decrease(@Param("userId") Integer userId, @Param("money") BigDecimal money);

}