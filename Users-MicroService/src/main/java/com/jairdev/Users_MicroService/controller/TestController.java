package com.jairdev.Users_MicroService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class TestController {
    @Value("${auth.jwt.secret}")
    private String secret;


    @GetMapping("/test")
    public String test() {

        return secret;
    }
}
