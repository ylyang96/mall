package com.yl.mall;

import com.yl.mall.dubbo.service.EchoInfoService;
import com.yl.mall.dubbo.service.impl.EchoInfoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author ylyang
 * @date 2021/1/28
 */

@SpringBootApplication
@DubboComponentScan(basePackages = "com.yl.mall.dubbo.service")
public class MallServiceApplication {

//    public static void main(String[] args) throws IOException {
//        //SpringApplication.run(MallServiceApplication.class, args);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
//        context.start();
//        System.in.read(); // 按任意键退出
//    }
//
    private static String zookeeperHost = System.getProperty("zookeeper.address", "121.41.9.85");

    public static void main(String[] args) throws IOException, InterruptedException {
        //SpringApplication.run(MallServiceApplication.class, args);
        ServiceConfig<EchoInfoService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(EchoInfoService.class);
        service.setRef(new EchoInfoServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}
