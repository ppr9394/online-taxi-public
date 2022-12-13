package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVerificationcodeClient;
import com.mashibing.internalcommon.dto.ResponeseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;

    private String verificationPrefix = "passenger-verification-code";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponeseResult generatorCode(String passengerPhone){

        //调用验证码服务，获取验证码
        System.out.println("调用验证码服务，获取验证码");
        ResponeseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("收到的验证码："+numberCode);
        //存入redis
        System.out.println("存入redis");
        String key = verificationPrefix +passengerPhone;
        //存入redis key value 过期时间
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        // 通过短信服务商发送验证码
        return ResponeseResult.success();

    }
}
