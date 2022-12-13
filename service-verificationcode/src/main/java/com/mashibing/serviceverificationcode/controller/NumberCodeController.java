package com.mashibing.serviceverificationcode.controller;

import com.mashibing.internalcommon.dto.ResponeseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponeseResult numberCode(@PathVariable("size") int size){

        System.out.println("size:"+size);

        double mathRandom = (Math.random()*9+1)*Math.pow(10,size-1);
        int resultInt = (int)mathRandom;
        System.out.println("生成的验证码："+resultInt);
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);
        return ResponeseResult.success(response);
    }
}
