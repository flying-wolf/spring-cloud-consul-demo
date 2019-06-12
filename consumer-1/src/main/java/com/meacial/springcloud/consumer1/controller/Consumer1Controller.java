package com.meacial.springcloud.consumer1.controller;

import com.meacial.springcloud.consumer1.service.ServiceProduce1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Consumer1Controller {
    @Autowired
    private ServiceProduce1 serviceProduce1;
    @GetMapping("/c/1")
    public String c1() {
        return serviceProduce1.doRequest();
    }

    @GetMapping("/c/2")
    public String c1(HttpServletRequest request, HttpServletResponse response) {
        return serviceProduce1.doRequest1(request, response);
    }

}
