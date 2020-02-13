package com.ahmedc2l.userauthstarter.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <h1>RetrofitClient</h1>
 * <p>This singletone class creates one retrofit instance through the app.</p>
 *
 * @author Ahmed Fathy
 * @since 2019-Jun-10
 * @version 1.0
 * */
public class RetrofitClient {
    private static Retrofit instance = null;
    private static OkHttpClient okHttpClient;

    private static OkHttpClient getOkHttpClient(){
        if(okHttpClient == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
        }
        return okHttpClient;
    }

    public static Retrofit getClientInstance(String baseUrl){
        if(instance == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            instance = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return instance;
    }
}
