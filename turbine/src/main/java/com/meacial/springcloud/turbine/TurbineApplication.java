package com.meacial.springcloud.turbine;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
//@EnableBinding(Processor.class)
@EnableBinding
public class TurbineApplication {

    public static void main(String[] args) {

        SpringApplication.run(TurbineApplication.class, args);

    }


    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String doSt(String payload) {
        System.out.println("-----------" + payload);
        return payload;
    }

}
