package com.example.user.mymap;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import android.widget.TextView;
import java.net.HttpURLConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
/**
 * Created by Sd on 23.02.2017.
 */

public class choise extends AppCompatActivity{
     String query;
    HttpURLConnection connection = null;
    String finalstr;
    public TextView tv;
    //boolean y=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choise);
        Service s = App.getApi();
        s.getVersionGet().enqueue(new Callback<List<ResponcesService>>() {
            @Override
            public void onResponse(Call<List<ResponcesService>> call, Response<List<ResponcesService>> response) {
                if (response.isSuccessful()) {
                    //response.body().get(0).getVersion();
                    if(response.body().get(0).getVersion().equals("1.0")) {
                        finalstr = "обновление не требуется";
                       // y=true;
                    }
                    else
                        finalstr= "обновление требуется!";
                    tv.setText(finalstr);
                }
            }

            @Override
            public void onFailure(Call<List<ResponcesService>> call, Throwable t) {
                finalstr="noo";
                tv.setText(finalstr);
            }
        });



        tv = (TextView) findViewById(R.id.textview);

        tv.setText(finalstr);
    }
}
