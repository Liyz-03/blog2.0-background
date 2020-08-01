package com.hiworlds.bbblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(basePackages = "com.hiworlds.bbblog.mapper")
//@ServletComponentScan(basePackages = "com.hiworlds.bbblog.filter")
@SpringBootApplication

public class BbblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbblogApplication.class, args);
    }

}
