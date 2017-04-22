package com.karangop.lovecalculator.network;

import com.karangop.lovecalculator.models.Love;

import java.sql.Wrapper;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by karan_000 on 14-04-2017.
 */

public interface Calculator {

//    @GET("{fname}{sname}")
//    Call<Love> getResult(@Path("fname") String fname, @Path("sname") String sname);
    @GET("getPercentage/")
    Call<Love> getAll(@QueryMap Map<String,String> queryMap);

}
