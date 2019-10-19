package com.moringaschool.e_temberere.network;


import com.moringaschool.e_temberere.models.ApiClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {

    @GET("businesses/search")
    Call<ApiClass> getSites(
            @Query("location") String location,
            @Query("term") String term
    );
}
