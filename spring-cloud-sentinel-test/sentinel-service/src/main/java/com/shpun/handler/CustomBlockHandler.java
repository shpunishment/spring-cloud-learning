package com.shpun.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shpun.model.vo.ResultVo;

/**
 * @Description:
 * @Author: sun
 * @Date: 2020/9/28 11:39
 */
public class CustomBlockHandler {

    /**
     * public static
     * @param exception
     * @return
     */
    public static ResultVo<?> handleException2(BlockException exception) {
        return ResultVo.failure(500, "handleException2 资源：" + exception.getRule().getResource() + " 限流成功");
    }

}
