package com.fungeonstudio.diagonline.recycler;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fungeonstudio.diagonline.R;
import com.fungeonstudio.diagonline.utils.CircleGlide;

import java.util.List;

/**
 * Created by Dytstudio.
 */

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MyViewHolder> {

    private List<Hospitals> items;
    private Context context;
    private boolean active;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView recipe, time;
        public RatingBar ratingBar;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);

            recipe = (TextView) view.findViewById(R.id.tv_recipe_name);
            time = (TextView) view.findViewById(R.id.tv_time);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            imageView = (ImageView) view.findViewById(R.id.iv_recipe);
        }


    }


    public HospitalAdapter(List<Hospitals> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Hospitals itemHospital = items.get(position);
        holder.recipe.setText(itemHospital.getName());
        holder.time.setText(itemHospital.getLocation());
        holder.ratingBar.setRating(3);
        Glide.with(context)
                .load(Uri.parse("https://images.pexels.com/photos/159887/pexels-photo-159887.jpeg?h=350&auto=compress"))
                .transform(new CircleGlide(context))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}