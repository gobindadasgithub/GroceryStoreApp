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
import com.example.mygrocerystore.model.NavCategoryModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NavCategoryAdapter extends RecyclerView.Adapter<NavCategoryAdapter.ViewHolder> {


    private final List<NavCategoryModel> list;
    Context context;

    public NavCategoryAdapter(List<NavCategoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nav_category_iteam, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int i) {
        try {
            Glide.with(context).load(list.get(i).getImg_uri()).into(viewHolder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.name.setText(list.get(i).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.description.setText(list.get(i).getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            viewHolder.discount.setText(list.get(i).getDiscount());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private final TextView name;
        private TextView description;
        private TextView discount;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemView=itemView.findViewById(R.id.nav_category_img);
            name=itemView.findViewById(R.id.nav_category_name);
            description=itemView.findViewById(R.id.nav_category_description);
            discount=itemView.findViewById(R.id.nav_category_discount);

        }
    }
}
