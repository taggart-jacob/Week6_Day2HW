package com.example.week6_day2hw.views.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.week6_day2hw.R;
import com.example.week6_day2hw.model.datasource.flickrobjects.Item;
import com.example.week6_day2hw.views.activity.FullSizeFlickr;

import java.util.List;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder> {

    List<Item> items;
    ImageView imgThumb;

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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(final View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
                dialog.setTitle("Select Image Size");
                final Intent intent = new Intent(view.getContext(), FullSizeFlickr.class);
                intent.putExtra("String_needed", imageURL);


                dialog.setPositiveButton("Show Large Image", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        view.getContext().startActivity(intent);
                    }

                });

                dialog.setNegativeButton("Show Regular Size", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        AlertDialog.Builder thumbDialog = new AlertDialog.Builder(view.getContext());

                        LayoutInflater inflater = LayoutInflater.from(view.getContext());
                        View v = inflater.inflate(R.layout.dialog_flickr_image, null);
                        imgThumb = v.findViewById(R.id.imgDialog);
                        thumbDialog.setView(v);
                        Glide.with(imgThumb).load(imageURL).into(imgThumb);
                        thumbDialog.create();
                        thumbDialog.show();
                    }
                });

                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return true;
            }
        });
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
