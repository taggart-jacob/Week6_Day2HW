package com.example.week6_day2hw.model.datasource.remote;

import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlickrPicturesService {
    @GET
    Observable<FlickrObject> getFlickrObjects(@Url String api_url);
}
