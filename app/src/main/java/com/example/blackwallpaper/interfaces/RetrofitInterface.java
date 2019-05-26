package com.example.blackwallpaper.interfaces;

import com.example.blackwallpaper.model.AuthObject;
import com.example.blackwallpaper.model.CarClass;
import com.example.blackwallpaper.model.City;
import com.example.blackwallpaper.model.ShowRoom;
import com.example.blackwallpaper.model.UserInfo;

import java.util.List;

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
    Call<AuthObject>getAuthToken(@Header("Authorization") String s,
                              @Field("grant_type") String q,
                              @Field("scope") String scope);
    @GET("Classes")
    Call<List<CarClass>> getClasses();

    @GET("cities")
    Call<List<City>> getCities();

    @GET("showrooms")
    Call<List<ShowRoom>> getShorooms(@Query("cityid") int cityId);

    @POST("WorkSheets")
    Call<Void> sendData(@Body UserInfo userInfo);
}
