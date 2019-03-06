package org.crazyit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApp {
    
    
    // 数据列表每页的数据量
    public final static int PAGE_SIZE = 5;

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

}
