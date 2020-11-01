package com.example.user.mymap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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

public class MainActivity extends Activity implements View.OnClickListener {
    GoogleMap googleMap;
    Button choose;

   /* String query;
    HttpURLConnection connection = null;
    String finalstr;
    public TextView tv;
    boolean y=true;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createMapView();
       // finalstr = "bwa";
        //addMarker();
        onMapReady(googleMap);
        create11route();
        choose = (Button) findViewById(R.id.choose);
        choose.setOnClickListener(this);
        /*Service s = App.getApi();
        s.getVersionGet().enqueue(new Callback<List<ResponcesService>>() {
            @Override
            public void onResponse(Call<List<ResponcesService>> call, Response<List<ResponcesService>> response) {
                if (response.isSuccessful()) {
                    //response.body().get(0).getVersion();
                    if(response.body().get(0).getVersion().equals("1.0")) {
                        finalstr = "обновление не требуется";
                        y=true;
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

        tv.setText(finalstr);*/
    }


    public void onMapReady(GoogleMap map) {
        LatLng dnepr = new LatLng(48.464717, 35.046183);
        map.addMarker(new MarkerOptions().position(dnepr).title("Marker in Dnepr")
                /*BitmapDescriptorFactory.fromPath()*/);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dnepr, 13));
    }

    private void createMapView() {

        try {
            if (null == googleMap) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();

                if (null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception) {
            Log.e("mapApp", exception.toString());
        }
    }

    private void create11route() {
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(48.384557, 34.999485))
                .add(new LatLng(48.399368, 35.000533))
                .add(new LatLng(48.399212, 35.005898))
                .add(new LatLng(48.399212, 35.005898))
                .add(new LatLng(48.398027, 35.010633))
                .add(new LatLng(48.397923, 35.011547))
                .add(new LatLng(48.397727, 35.015757))
                .add(new LatLng(48.397675, 35.015972))
                .add(new LatLng(48.389095, 35.039756))
                .add(new LatLng(48.397778, 35.020113))
                .add(new LatLng(48.398064, 35.021405))
                .add(new LatLng(48.398435, 35.022945))
                .add(new LatLng(48.399072, 35.024766))
                .add(new LatLng(48.399182, 35.025555))
                .add(new LatLng(48.399075, 35.025699))
                .add(new LatLng(48.398259, 35.025785))
                .add(new LatLng(48.398259, 35.025785))
                .add(new LatLng(48.396207, 35.027055))
                .add(new LatLng(48.391165, 35.031795))
                .add(new LatLng(48.389576, 35.037784))
                .add(new LatLng(48.389149, 35.038062))
                .add(new LatLng(48.388867, 35.039066))
                .add(new LatLng(48.388880, 35.039529))
                .add(new LatLng(48.389040, 35.039835))
                .add(new LatLng(48.389229, 35.039795))
                .add(new LatLng(48.389355, 35.039532))
                .add(new LatLng(48.389364, 35.039285))
                .add(new LatLng(48.389238, 35.039073))
                .add(new LatLng(48.389342, 35.038676))
                .color(Color.BLUE)
                .width(5);
        googleMap.addPolyline(polylineOptions);

        PolylineOptions polylineOptions2 = new PolylineOptions()
                .add(new LatLng(48.384557, 34.999485))
                .add(new LatLng(48.384360, 34.999469))
                .add(new LatLng(48.384359, 34.999290))
                .add(new LatLng(48.384923, 34.999348))
                .add(new LatLng(48.399362, 35.000338))
                .add(new LatLng(48.399212, 35.005898))
                .add(new LatLng(48.399070, 35.006944))
                .add(new LatLng(48.398027, 35.010633))
                .add(new LatLng(48.397923, 35.011547))
                .add(new LatLng(48.397727, 35.015757))
                .add(new LatLng(48.397772, 35.015977))
                .add(new LatLng(48.397728, 35.016996))
                .add(new LatLng(48.397731, 35.018307))
                .add(new LatLng(48.397731, 35.018307))
                .add(new LatLng(48.398064, 35.021405))
                .add(new LatLng(48.398064, 35.021405))
                .add(new LatLng(48.399072, 35.024766))
                .add(new LatLng(48.399444, 35.025846))
                .add(new LatLng(48.399355, 35.026065))
                .add(new LatLng(48.399244, 35.026111))
                .add(new LatLng(48.398259, 35.025785))
                .add(new LatLng(48.397870, 35.025940))
                .add(new LatLng(48.396207, 35.027055))
                .add(new LatLng(48.391165, 35.031795))
                .add(new LatLng(448.389342, 35.038676))
                .color(Color.GREEN)
                .width(5);
        googleMap.addPolyline(polylineOptions2);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.388294, 34.999673)).icon(BitmapDescriptorFactory.fromResource(R.drawable.stop2)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.395763, 35.000188)).icon(BitmapDescriptorFactory.fromResource(R.drawable.stop2)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.393544, 35.029568)).icon(BitmapDescriptorFactory.fromResource(R.drawable.stop2)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(48.395871, 35.000318)).icon(BitmapDescriptorFactory.fromResource(R.drawable.stop2)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.choose:
                Intent inten = new Intent(MainActivity.this, choise.class);
                startActivity(inten);
                break;
            default:

                break;

        }
    }
}
