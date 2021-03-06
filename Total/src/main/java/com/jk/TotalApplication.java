package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.jk.mapper")/*扫描持久层*/
@EnableTransactionManagement
public class TotalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TotalApplication.class, args);
    }

}
