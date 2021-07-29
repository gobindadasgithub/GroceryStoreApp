package com.example.mygrocerystore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mygrocerystore.R;
import com.example.mygrocerystore.model.PopularModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private Context context;
    private List<PopularModel> popularModelList;

    public PopularAdapter(Context context, List<PopularModel> popularModelList) {
        this.context = context;
        this.popularModelList = popularModelList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popular_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(popularModelList.get(i).getImage_url()).into(viewHolder.pop_image);
        viewHolder.name.setText(popularModelList.get(i).getName());
        viewHolder.description.setText(popularModelList.get(i).getDescription());
        viewHolder.discount.setText(popularModelList.get(i).getDiscount());
        viewHolder.rathing.setText(popularModelList.get(i).getRatingber());


    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pop_image;
        TextView name,discount,description,rathing;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            pop_image=itemView.findViewById(R.id.pop_image);
            name=itemView.findViewById(R.id.pop_name);
            discount=itemView.findViewById(R.id.pop_discount);
            description=itemView.findViewById(R.id.pop_dec);
            rathing=itemView.findViewById(R.id.pop_ratingber);


        }
    }
}
