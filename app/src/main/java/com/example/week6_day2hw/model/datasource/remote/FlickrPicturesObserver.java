package com.example.week6_day2hw.model.datasource.remote;

import android.util.Log;

import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FlickrPicturesObserver implements Observer<FlickrObject> {

    FlickrCallback flickrCallback;
    FlickrObject flickrObject;

    public FlickrPicturesObserver(FlickrCallback flickrCallback) {
        this.flickrCallback = flickrCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(FlickrObject flickrObject) {
        this.flickrObject = flickrObject;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "FLICKN' FAILURE", e);
    }

    @Override
    public void onComplete() {
        flickrCallback.onReturnFlickrObject(flickrObject);
    }
}
