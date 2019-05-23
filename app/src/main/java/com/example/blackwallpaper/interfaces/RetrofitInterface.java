package com.example.blackwallpaper.interfaces;

import com.example.blackwallpaper.model.AuthObject;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST(".")
    Call<String >getAuthToken(@Header("Authorization") String s,
                              @Field("grant_type") String q,
                              @Field("scope") String scope);
    @GET("Classes")
    Call<CarClass> getClasses();

    @GET("cities")
    Call<City> getCities();

    @GET("showrooms")
    Call<ShowRoom> getShorooms(@Query("cityid") String cityId);
}
