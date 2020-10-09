package com.shpun.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shpun.handler.CustomBlockHandler;
import com.shpun.model.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/28 11:37
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按url限流，有默认的限流处理逻辑
     *
     * @return
     */
    @SentinelResource(value = "url")
    @GetMapping("/url")
    public ResultVo<?> url() {
        return ResultVo.ok(200, "/url 请求成功");
    }

    /**
     * 按资源名称限流，注意资源名称要相同。
     * 需要指定限流处理逻辑。
     *
     * @return
     */
    @SentinelResource(value = "resource", blockHandler = "handleException")
    @GetMapping("/resource")
    public ResultVo<?> resource() {
        return ResultVo.ok(200, "/resource 请求成功");
    }

    /**
     * 按资源名称限流处理，方法的访问修饰符需为public
     * @param exception
     * @return
     */
    public ResultVo<?> handleException(BlockException exception) {
        return ResultVo.failure(500, "handleException 资源：" + exception.getRule().getResource() + " 限流成功");
    }

    /**
     * 按资源名称限流，注意资源名称要相同。
     * 自定义限流处理逻辑，指定CustomBlockHandler和其中的static方法handleException2。
     *
     * @return
     */
    @SentinelResource(value = "resource2", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException2")
    @GetMapping("/resource2")
    public ResultVo<?> resource2() {
        return ResultVo.ok(200, "/resource2 请求成功");
    }

}

