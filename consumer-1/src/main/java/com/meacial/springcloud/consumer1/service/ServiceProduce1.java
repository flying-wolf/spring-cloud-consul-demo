package com.meacial.springcloud.consumer1.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceProduce1 {
    @RequestMapping(value = "/produce1/mth0", method = RequestMethod.GET)
    String doRequest();

    @RequestMapping(value = "/produce1/mth1", method = RequestMethod.GET)
    String doRequest1(HttpServletRequest httpServletRequest, HttpServletResponse response);

}
