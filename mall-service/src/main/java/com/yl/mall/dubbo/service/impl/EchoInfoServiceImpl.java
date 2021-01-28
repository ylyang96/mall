package com.yl.mall.dubbo.service.impl;

import com.yl.mall.dubbo.service.EchoInfoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ylyang
 * @date 2021/1/28
 */
@DubboService(version = "1.0")
public class EchoInfoServiceImpl implements EchoInfoService {
    @Override
    public String getString() {
        return "hello-world";
    }
}
