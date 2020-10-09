package com.shpun.service;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 17:12
 */
public interface UserRibbonService {

    ResultVo<?> add(User user);

    ResultVo<?> delete(Integer userId);

    ResultVo<?> update(User user);

    ResultVo<?> get(Integer userId);

    /**
     * 测试服务降级
     *
     * @param userId
     * @return
     */
    ResultVo<?> getForTestFallback(Integer userId);

    /**
     * 测试服务降级，忽略部分异常不产生降级
     * @param userId
     * @return
     */
    ResultVo<?> getForTestFallbackWithIgnoreExceptions(Integer userId);

}
