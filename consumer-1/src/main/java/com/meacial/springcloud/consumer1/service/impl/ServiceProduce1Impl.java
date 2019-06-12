package com.meacial.springcloud.consumer1.service.impl;

import com.meacial.springcloud.consumer1.service.ServiceProduce1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "produce-1",fallback = ServiceProduce1Impl.ServiceProduce1Callback.class)
public interface ServiceProduce1Impl extends ServiceProduce1 {

    @Component
    class ServiceProduce1Callback implements ServiceProduce1Impl {
        @Override
        public String doRequest() {
            return "Produce-1 CircuitBreaker For doRequest()";
        }

        @Override
        public String doRequest1(HttpServletRequest httpServletRequest, HttpServletResponse response) {
            return null;
        }
    }
}
