package com.shpun.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserRibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 17:13
 */
@Service("userRibbonService")
public class UserRibbonServiceImpl implements UserRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @Override
    public ResultVo<?> add(User user) {
        return restTemplate.postForObject(userServiceUrl + "/api/user/add", user, ResultVo.class);
    }

    @Override
    public ResultVo<?> delete(Integer userId) {
        return restTemplate.getForObject(userServiceUrl + "/api/user/delete/{0}", ResultVo.class, userId);
    }

    @Override
    public ResultVo<?> update(User user) {
        return restTemplate.postForObject(userServiceUrl + "/api/user/update", user, ResultVo.class);
    }

    @Override
    public ResultVo<?> get(Integer userId) {
        return restTemplate.getForObject(userServiceUrl + "/api/user/{0}", ResultVo.class, userId);
    }

    @SentinelResource(value = "fallback", fallback = "fallback")
    @Override
    public ResultVo<?> getForTestFallback(Integer userId) {
        return this.get(userId);
    }

    /**
     * fallback 方法访问修饰符需要为 public
     * @param userId
     * @return
     */
    public ResultVo<?> fallback(Integer userId) {
        return ResultVo.failure(500, "fallback(" + userId + ") 服务调用异常");
    }

    @SentinelResource(value = "fallbackException", fallback = "fallback2", exceptionsToIgnore = { NullPointerException.class })
    @Override
    public ResultVo<?> getForTestFallbackWithIgnoreExceptions(Integer userId) {
        if (userId == 1) {
            throw new IndexOutOfBoundsException();
        } else if (userId == 2) {
            throw new NullPointerException();
        }
        return this.get(userId);
    }

    /**
     * fallback 方法访问修饰符需要为 public
     * @param userId
     * @param e
     * @return
     */
    public ResultVo<?> fallback2(Integer userId, Throwable e) {
        return ResultVo.failure(500, "fallback2(" + userId + ") 服务调用异常。异常：" + e.getClass());
    }

}
