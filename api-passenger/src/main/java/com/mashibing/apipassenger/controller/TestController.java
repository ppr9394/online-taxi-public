
package com.mashibing.apipassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Retention;

public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test api passenger";
    }
}
