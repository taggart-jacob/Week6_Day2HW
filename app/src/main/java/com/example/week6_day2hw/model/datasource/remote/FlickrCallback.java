package com.example.week6_day2hw.model.datasource.remote;

import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;

public interface FlickrCallback {
    void onReturnFlickrObject(FlickrObject flickrObject);
}
