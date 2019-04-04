package com.binbol.util.sms;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SmsRetrofit {
   @POST("smsservice/api/sendSms")
   Call<SmsResponseDto> sendSms(@Body SmsRequestDto smsRequest);

}
