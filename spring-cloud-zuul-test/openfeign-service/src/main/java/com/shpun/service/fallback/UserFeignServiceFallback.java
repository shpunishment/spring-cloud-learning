package com.shpun.service.fallback;

import com.shpun.model.User;
import com.shpun.model.vo.ResultVo;
import com.shpun.service.UserFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/21 11:18
 */
@Component
public class UserFeignServiceFallback implements UserFeignService {

    @Override
    public ResultVo<?> add(User user) {
        return ResultVo.failure(500, "add 服务调用异常");
    }

    @Override
    public ResultVo<?> delete(Integer userId) {
        return ResultVo.failure(500, "delete 服务调用异常");
    }

    @Override
    public ResultVo<?> update(User user) {
        return ResultVo.failure(500, "update 服务调用异常");
    }

    @Override
    public ResultVo<User> get(Integer userId) {
        return ResultVo.build(500, null,"get 服务调用异常");
    }

    @Override
    public ResultVo<List<User>> getByUserIdList(List<Integer> userIdList) {
        return ResultVo.build(500, null,"getByUserIdList 服务调用异常");
    }
}
