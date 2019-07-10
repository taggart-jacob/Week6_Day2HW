package com.example.week6_day2hw.model.datasource.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFlickr {

    //COME BACK TO THIS IF THERE ARE ISSUES
    public static final String BASE_URL = "https://api.flickr.com/";

    private Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public FlickrPicturesService getFlickrPicturesService(){
        return getRetrofit().create(FlickrPicturesService.class);
    }
}
