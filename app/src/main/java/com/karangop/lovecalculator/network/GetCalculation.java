package com.karangop.lovecalculator.network;

import android.os.AsyncTask;

import com.karangop.lovecalculator.models.Love;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by karan_000 on 14-04-2017.
 */

public class GetCalculation extends AsyncTask<Map<String,String>, Void, Love> {


    @Override
    protected Love doInBackground(Map<String,String>... params) {

        Map<String,String> query = params[0];

        Calculator calculator = new Interceptors().getPercentage();
        Call<Love> call = calculator.getAll(query);

        try {
            Response<Love> response = call.execute();
            if (200 == response.code() && response.isSuccessful()){
                return response.body();
            }
            else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
