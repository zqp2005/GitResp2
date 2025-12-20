package com.zqp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zqp.mapper")
public class ZqpdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqpdemoApplication.class, args);
    }

}
