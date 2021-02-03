package com.yl.mall;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ylyang
 * @date 2021/1/28
 */

@SpringBootApplication
@DubboComponentScan(basePackages = "com.yl.mall.dubbo.service")
public class MallServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceApplication.class, args);
    }



}
