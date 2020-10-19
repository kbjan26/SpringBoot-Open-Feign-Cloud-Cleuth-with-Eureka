package com.example.springbootsleuthzipkin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MicroServiceFourController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/greetings")
    private String greetings() {
        log.debug("Inside service 4 greetings");
        return "Hello from :" + appName;
    }

    @PostMapping("/divide")
    private Integer divide(@RequestParam Integer num1,@RequestParam Integer num2) {
        return num1 / num2;
    }
}
