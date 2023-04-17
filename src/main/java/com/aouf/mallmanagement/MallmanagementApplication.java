package com.aouf.mallmanagement;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(" com.aouf.mallmanagement.mapper")
public class MallmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallmanagementApplication.class, args);
    }

}
