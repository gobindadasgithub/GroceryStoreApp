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
import com.example.mygrocerystore.model.ViewAllModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {
    List<ViewAllModel> list;
    Context context;

    public ViewAllAdapter(List<ViewAllModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_iteam,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());

        if (list.get(position).getType().equals("egg")){
            holder.price.setText(list.get(position).getPrice()+"/dozen");

        }
        if (list.get(position).getType().equals("milk")){
            holder.price.setText(list.get(position).getPrice()+"/Kg");

        }



        try {
            holder.rating.setText(list.get(position).getRating());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Glide.with(context).load(list.get(position).getImg_uri()).into(holder.imageView);
        try {
            holder.price.setText(list.get(position).getPrice()+"/Kg");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name,description,rating,price;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);


            imageView=itemView.findViewById(R.id.view_img);
         name=itemView.findViewById(R.id.view_name);
         description=itemView.findViewById(R.id.view_description);
            try {
                rating=itemView.findViewById(R.id.view_rating);
            } catch (Exception e) {
                e.printStackTrace();
            }
            price=itemView.findViewById(R.id.view_price);

        }
    }


}
