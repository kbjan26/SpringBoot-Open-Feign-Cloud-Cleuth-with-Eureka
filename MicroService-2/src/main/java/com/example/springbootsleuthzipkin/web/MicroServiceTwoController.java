package com.example.springbootsleuthzipkin.web;

import com.example.springbootsleuthzipkin.client.FeignClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MicroServiceTwoController {

    @Autowired
    private FeignClientConfig feignClientConfig;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/greetings")
    private String greetings() {
        log.debug("Inside service 2 greetings");
        return "Hello from " + appName + ".Message received from producer " + feignClientConfig.greetings() + ".";
    }

    @PostMapping("/divide")
    private Integer divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        return feignClientConfig.divide(num1,num2);
    }
}
