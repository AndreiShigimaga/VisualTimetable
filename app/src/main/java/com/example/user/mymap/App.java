package com.example.user.mymap;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import android.app.Application;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by Sd on 23.02.2017.
 */

public class App extends Application {
    private static Service service;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://alexandryalovoy.h1n.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Service.class);
    }

    public static Service getApi() {
        return service;
    }

    /*@Override
    public Void doInBackground( Void... voids ){
        final String url = "http://alexandryalovoy.h1n.ru/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        service.getVersionGet().enqueue(new Callback<List<ResponcesService>>() {
            @Override
            public void onResponse(Call<List<ResponcesService>> call, Response<List<ResponcesService>> response) {
                if (response.isSuccessful()) {
                    response.body().get(0).getVersion();
                }
            }

            @Override
            public void onFailure(Call<List<ResponcesService>> call, Throwable t) {

            }
        });

        try {
            for (ResponcesService version : responce.execute().body())
            {

                //Log.e("Version: ", version.getVersion());
            }


        }
        catch (IOException e){
            e.printStackTrace();
        }

        return null;

    }*/
}
