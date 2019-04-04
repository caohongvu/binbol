package com.binbol.util.sms;

import java.io.IOException;


public interface SmsService {
    SmsResponseDto sendSms(String phone, String content) throws IOException;
}
