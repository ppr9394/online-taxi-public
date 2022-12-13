package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.VerificationCodeDTO;
import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.internalcommon.dto.ResponeseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
   public ResponeseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        // 调取验证码发送服务
        return verificationCodeService.generatorCode(passengerPhone);
    }
}
