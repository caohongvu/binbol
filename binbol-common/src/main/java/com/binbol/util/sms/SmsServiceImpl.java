package com.binbol.util.sms;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
@PropertySource("classpath:sms-config.properties")
public class SmsServiceImpl implements SmsService{

    @Autowired
    private Environment env;

    @Override
    public SmsResponseDto sendSms(String phone, String content) throws IOException {
        String SMS_URL = env.getProperty("smsurl");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SMS_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();
        SmsRetrofit smsRetrofit = retrofit.create(SmsRetrofit.class);
        SmsRequestDto smsRequest = new SmsRequestDto( content, phone);
        Call<SmsResponseDto> call = smsRetrofit.sendSms(smsRequest);
        SmsResponseDto smsResponse = call.execute().body();
        return smsResponse;
    }
}
