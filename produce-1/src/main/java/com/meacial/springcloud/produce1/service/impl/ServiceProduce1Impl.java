package com.meacial.springcloud.produce1.service.impl;

import com.meacial.springcloud.produce1.service.ServiceProduce1;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ServiceProduce1Impl implements ServiceProduce1 {
    @Override
    public String doRequest() {
        return "Produce-1 Success For doRequest()";
    }

    @Override
    public String doRequest1(HttpServletRequest httpServletRequest, HttpServletResponse response) {

        System.out.println(httpServletRequest.getParameter("name"));

        System.out.println(httpServletRequest.getParameterMap());

        return "httpServletRequest";
    }
}
