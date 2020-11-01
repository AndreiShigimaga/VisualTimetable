package com.example.user.mymap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by Sd on 25.02.2017.
 */

public interface Service {
    @GET("/?action=check")
    Call<List<ResponcesService>> getVersionGet();
}
