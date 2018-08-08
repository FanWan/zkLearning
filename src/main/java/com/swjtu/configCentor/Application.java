package com.swjtu.configCentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanfan01 on 2018/8/7.
 */

@RestController
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    public String index(){
        return "hello, spring boot";
    }


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }





}
