package com.karangop.lovecalculator.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karan_000 on 14-04-2017.
 */

public class Interceptors {

    private static final String BASE_URL = "https://love-calculator.p.mashape.com/";

    public Calculator getPercentage(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-Mashape-Key", "KtLpmuiDaDmshfCXQA52DNfNPaPGp1Y7ZNSjsniSOLHkFWTqIN")
                        .header("Accept", "application/json")
                        .build();

                Response response = chain.proceed(request);

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Calculator service = interceptor.create(Calculator.class);
        return service;
    }
}
