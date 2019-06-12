package com.meacial.springcloud.produce1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
public class Produce1Application {
    public static void main(String[] args) {
        SpringApplication.run(Produce1Application.class, args);
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "HELLO WORLD";
    }
}
