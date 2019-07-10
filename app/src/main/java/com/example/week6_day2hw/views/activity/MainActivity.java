package com.example.week6_day2hw.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.week6_day2hw.R;
import com.example.week6_day2hw.databinding.ActivityMainBinding;
import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;
import com.example.week6_day2hw.viewmodels.FlickrListViewModel;
import com.example.week6_day2hw.views.adapters.FlickrRVAdapter;

public class MainActivity extends AppCompatActivity {

    FlickrListViewModel flickrListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flickrListViewModel = new FlickrListViewModel();
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewmodel(flickrListViewModel);
        flickrListViewModel.getFlickrObjects();
    }

    @BindingAdapter("bind:flickrList")
    public static void initRecyclerView(RecyclerView rvFlickr, FlickrObject flickrObject){
        if (flickrObject!=null){
            FlickrRVAdapter adapter = new FlickrRVAdapter(flickrObject.getItems());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rvFlickr.getContext());
            rvFlickr.setLayoutManager(layoutManager);
            rvFlickr.setAdapter(adapter);
        }
    }
}
