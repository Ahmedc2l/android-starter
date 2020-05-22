package com.ahmedc2l.userauthstarter.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * <h1>ApiEndPoints</h1>
 * <p>This interface defines different network callbacks using Retrofit.</p>
 *
 * @author Ahmed Fathy
 * @since 2019-Jun-10
 * @version 1.0
 * */
public interface ApiEndPoints {
    // Authentication
    // TODO add your backend urls for the below different calls
    @POST("")
    Call<ResponseBody> LOGIN(@HeaderMap Map<String, String> headers, @Body Map<String, Object> body);
    @POST("")
    Call<ResponseBody> LOGIN_SOCIAL(@HeaderMap Map<String, String> headers, @Body Map<String, Object> body);
    @POST("")
    Call<ResponseBody> REGISTER(@HeaderMap Map<String, String> headers, @Body Map<String, Object> body);
}
