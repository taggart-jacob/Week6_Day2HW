package com.example.week6_day2hw.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.week6_day2hw.R;
import com.example.week6_day2hw.model.datasource.flickrobjects.FlickrObject;
import com.example.week6_day2hw.model.datasource.flickrobjects.Item;

import java.util.ArrayList;
import java.util.List;


public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder> {

    List<Item> items;

    public FlickrRVAdapter(List<Item> flickrObject){
        this.items = flickrObject;
    }

    @NonNull
    @Override
    public FlickrRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.flickr_object_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrRVAdapter.ViewHolder holder, int position) {
        final Item itemFlickr = items.get(position);
        final String flickrTitle = itemFlickr.getTitle();
        final String flickrLink = itemFlickr.getLink();
        final String imageURL = itemFlickr.getMedia().getM();


        holder.tvFlickrTitle.setText(flickrTitle);
        holder.tvFlickrLink.setText(flickrLink);
        Glide.with(holder.imgFlickr).load(imageURL).into(holder.imgFlickr);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFlickr;
        TextView tvFlickrTitle;
        TextView tvFlickrLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFlickr = itemView.findViewById(R.id.imgFlickr);
            tvFlickrTitle = itemView.findViewById(R.id.tvFlickrTitle);
            tvFlickrLink = itemView.findViewById(R.id.tvFlickrLink);
        }
    }
}
