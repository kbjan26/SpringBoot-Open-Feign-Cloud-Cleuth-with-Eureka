package com.example.springbootsleuthzipkin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Microservice-4")
public interface FeignClientConfig {

    @RequestMapping(method = RequestMethod.GET, value = "/greetings")
    String greetings();

    @RequestMapping(method=RequestMethod.POST,value="/divide")
    Integer divide(@RequestParam Integer num1, @RequestParam Integer num2);
}
