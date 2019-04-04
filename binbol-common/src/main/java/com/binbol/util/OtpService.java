package com.binbol.util;

import java.io.IOException;

import com.binbol.exception.BinbolRuntimeException;
import com.binbol.generator.OtpGenerator;
import com.binbol.message.EWSMessage;
import com.binbol.util.sms.SmsResponseDto;
import com.binbol.util.sms.SmsServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Description(value = "Service responsible for handling OTP related functionality.")
@Service
public class OtpService {

    private final Logger LOGGER = LoggerFactory.getLogger(OtpService.class);

    @Autowired
    private Environment env;

    private OtpGenerator otpGenerator;

    @Autowired
    private SmsServiceImpl smsService;
    /**
     * Constructor dependency injector
     * @param otpGenerator - otpGenerator dependency
     */
    public OtpService(OtpGenerator otpGenerator)
    {
        this.otpGenerator = otpGenerator;
    }

    /**
     * Method for generate OTP number
     *
     * @param key - provided key (ecoeUserId in this case)
     * @return boolean value (true|false)
     */
    public Boolean generateOtp(String key, String phone) throws IOException {
        // generate otp
        Integer otpValue = otpGenerator.generateOTP(key);
        if (otpValue == -1)
        {
            LOGGER.error("OTP generator is not working...");
            return  false;
        }
        String content = env.getProperty("content");
        LOGGER.info("Generated OTP: {}", otpValue);
        SmsResponseDto smsResponse = smsService.sendSms(phone,content + otpValue);
        LOGGER.info("Sms response: " + smsResponse.getDetailResponse());
        if(!("100").equals(smsResponse.getCodeResult())) {
            throw new BinbolRuntimeException(EWSMessage.SMS_FAILURE);
        }else {
            return true;
        }
    }

    /**
     * Method for validating provided OTP
     *
     * @param key - provided key
     * @param otpNumber - provided OTP number
     * @return boolean value (true|false)
     */
    public Boolean validateOTP(String key, Integer otpNumber)
    {
        // get OTP from cache
        Integer cacheOTP = otpGenerator.getOPTByKey(key);
        if (cacheOTP.equals(otpNumber))
        {
            otpGenerator.clearOTPFromCache(key);
            return true;
        }
        return false;
    }
}
