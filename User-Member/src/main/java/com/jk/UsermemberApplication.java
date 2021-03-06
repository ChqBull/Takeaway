package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication/*开启入口类*/
@EnableDiscoveryClient//表明是客户端,可以往注册中心注册
@EnableEurekaClient
@MapperScan("com.jk.mapper")/*扫描持久层*/
public class UsermemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermemberApplication.class, args);
    }

}
