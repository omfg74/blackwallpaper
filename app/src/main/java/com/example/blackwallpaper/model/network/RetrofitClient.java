package com.example.blackwallpaper.model.network;

import android.provider.SyncStateContract;

import androidx.annotation.Nullable;

import com.example.blackwallpaper.BuildConfig;
import com.example.blackwallpaper.interfaces.RetrofitInterface;
import com.example.blackwallpaper.model.AuthObject;
import com.example.blackwallpaper.model.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;


    public static Retrofit getInstance() {
        if (okHttpClient == null) {
            okHttpClient = getOkhttp();
        }
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASEURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    protected static OkHttpClient getOkhttp() {
        OkHttpClient okhttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(addInterceptor())
                .build();

        return okhttpClient;
    }

    private static Interceptor addInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
    private  Authenticator addAuthenticator(){
        return new Authenticator() {
            @Nullable
            @Override
            public Request authenticate(@Nullable Route route, Response response) {
                String accessToken = null;
                if(response.code()==200){

                }
                if(response.code()==201){

                }
                if(response.code()==401||response.code()==400){
                    if(response.headers().get("Unauthorized").equalsIgnoreCase("key_expired")){
                        RetrofitInterface retrofitInterface = getAdapterAuth().create(RetrofitInterface.class);
                        try {
                            retrofit2.Response<String> requeest = retrofitInterface.getAuthToken("Basic Q3VzdG9tR3JhbnRUeXBlQ2xpZW50SWQ6Q3VzdG9tR3JhbnRUeXBlQ2xpZW50U2VjcmV0","custom_client_credentials","profile").execute();
                            if(requeest.headers()!=null){
                               accessToken = requeest.headers().get("access_token");
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else {
                        return null;
                    }
                }
                if (accessToken!=null) {
                    return response.request().newBuilder()
                            .header("Authorization",accessToken)
                            .build();
                }else
                    return null;
            }
        };
    }

    private Retrofit getAdapterAuth() {
        Retrofit retrofit;
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(addInterceptor());
            if (BuildConfig.DEBUG) {
                httpClient.addInterceptor(addInterceptor());
            }

        retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.AUTHURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

        return retrofit;
    }
    }

