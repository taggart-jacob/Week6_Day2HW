package com.example.week6_day2hw.viewmodels;

import android.util.Log;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;
import com.example.week6_day2hw.model.datasource.remote.FlickrCallback;
import com.example.week6_day2hw.model.datasource.remote.FlickrPicturesObserver;
import com.example.week6_day2hw.model.datasource.remote.RetrofitFlickr;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FlickrListViewModel extends ViewModel implements FlickrCallback, Observable {

    public PropertyChangeRegistry getPropertyChangeRegistry() {
        return propertyChangeRegistry;
    }

    public void setPropertyChangeRegistry(PropertyChangeRegistry propertyChangeRegistry) {
        this.propertyChangeRegistry = propertyChangeRegistry;
    }

    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    @Bindable
    public FlickrObject flickrObject;

    public FlickrObject getFlickrObject() {
        return flickrObject;
    }

    public void setFlickrObject(FlickrObject flickrObject) {
        this.flickrObject = flickrObject;
    }

    public void getFlickrObjects(){
        RetrofitFlickr retrofitFlickr = new RetrofitFlickr();

        retrofitFlickr.getFlickrPicturesService()
                .getFlickrObjects("https://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlickrPicturesObserver(this));
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }

    @Override
    public void onReturnFlickrObject(FlickrObject flickrObject) {
        this.flickrObject = flickrObject;
        Log.d("TAG", flickrObject.getItems().get(0).getDescription());
        notifyOfAllPropertiesChanged();
    }

    public void notifyOfAllPropertiesChanged(){
        propertyChangeRegistry.notifyChange(this, 0);
    }


}
