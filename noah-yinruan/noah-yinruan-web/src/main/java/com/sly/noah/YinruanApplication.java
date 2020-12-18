package com.sly.noah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Created by wj on 2020/12/10
 * @Description TODO
 */
@SpringBootApplication
@ComponentScan("com.sly")

public class YinruanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YinruanApplication.class);
    }

}
