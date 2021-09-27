package com.lte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.lte.mapper")
public class LogintestApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogintestApplication.class, args);
    }

}
