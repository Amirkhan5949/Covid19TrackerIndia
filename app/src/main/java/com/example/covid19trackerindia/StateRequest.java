package com.example.covid19trackerindia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StateRequest {

    @GET("data.json")
    Call<StateWiseData> getstatewisedata();
}
