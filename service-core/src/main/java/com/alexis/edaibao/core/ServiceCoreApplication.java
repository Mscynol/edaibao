package com.alexis.edaibao.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cc-zj
 * @create 2022-04-12 16:06
 */
@SpringBootApplication
@ComponentScan({"com.alexis.edaibao"})
public class ServiceCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCoreApplication.class, args);
    }
}
