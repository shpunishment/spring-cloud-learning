package com.shpun.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserRibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/18 17:13
 */
@Service("userRibbonService")
public class UserRibbonServiceImpl implements UserRibbonService {

    private static final Logger logger = LoggerFactory.getLogger(UserRibbonServiceImpl.class);

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

    /**
     * 测试服务降级，未指定忽略异常
     * @param userId
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @Override
    public ResultVo<?> getForTestFallback(Integer userId) {
        return this.get(userId);
    }

    /**
     * 声明的参数需要包含controller的声明参数
     * @param userId
     * @return
     */
    private ResultVo<?> fallbackMethod(@PathVariable("userId") Integer userId) {
        return ResultVo.failure(500, "fallbackMethod(" + userId + ") 服务调用异常");
    }

    /**
     * 测试服务降级，指定忽略异常
     * @param userId
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethodWithIgnoreExceptions", ignoreExceptions = { NullPointerException.class })
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
     * 声明的参数需要包含controller的声明参数
     * @param userId
     * @return
     */
    private ResultVo<?> fallbackMethodWithIgnoreExceptions(@PathVariable("userId") Integer userId) {
        return ResultVo.failure(500, "fallbackMethodWithIgnoreExceptions(" + userId + ") 服务调用异常");
    }

    /**
     * 启用缓存，指定cacheKeyMethod和commandKey
     * @param userId
     * @return
     */
    @CacheResult(cacheKeyMethod = "getUserIdCacheKey")
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandKey = "getForTestCache")
    @Override
    public ResultVo<?> getForTestCache(Integer userId) {
        logger.info("调用 getForTestCache(" + userId + ")");
        return this.get(userId);
    }

    /**
     * 生成缓存key
     * @param userId
     * @return
     */
    private String getUserIdCacheKey(Integer userId) {
        return String.valueOf(userId);
    }

    /**
     * 删除缓存，指定commandKey和cacheKeyMethod，要和启用缓存一致
     * @param userId
     * @return
     */
    @CacheRemove(commandKey = "getForTestCache", cacheKeyMethod = "getUserIdCacheKey")
    @HystrixCommand
    @Override
    public ResultVo<?> deleteForRemoveCache(Integer userId) {
        logger.info("调用 deleteForRemoveCache(" + userId + ")");
        return this.delete(userId);
    }

    /**
     * 启用请求合并，指定batchMethod
     * @param userId
     * @return
     */
    @HystrixCollapser(batchMethod = "getByUserIdList", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    @Override
    public Future<User> getForTestCollapser(Integer userId) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                ResultVo<?> resultVo = restTemplate.getForObject(userServiceUrl + "/api/user/{0}", ResultVo.class, userId);
                User user = (User) resultVo.getData();
                logger.info("getForFuture(" + userId + ")");
                return user;
            }
        };
    }

    /**
     * 请求合并的方法需要注解@HystrixCommand
     * @param userIdList
     * @return
     */
    @HystrixCommand
    private List<User> getByUserIdList(List<Integer> userIdList) {
        logger.info("getByUserIdList(" + userIdList + ")");
        ResultVo<?> resultVo = restTemplate.getForObject(userServiceUrl + "/api/user/getByUserIdList?userIdList={0}", ResultVo.class, CollUtil.join(userIdList, ","));
        return (List<User>) resultVo.getData();
    }

}
