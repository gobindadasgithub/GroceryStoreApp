package com.example.mygrocerystore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mygrocerystore.R;
import com.example.mygrocerystore.activities.ViewActivity;
import com.example.mygrocerystore.model.HomeCategoryModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {

    private List<HomeCategoryModel> categorylist=new ArrayList<>();
    private Context context;

    public HomeCategoryAdapter(List<HomeCategoryModel> categorylist, Context context) {
        this.categorylist = categorylist;
        this.context = context;
    }



    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homecategory_iteam, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int i) {

        Glide.with(context).load(categorylist.get(i).getImg_uri()).into(viewHolder.home_category_img);
        viewHolder.name.setText(categorylist.get(i).getName());




        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ViewActivity.class);
                intent.putExtra("type",categorylist.get(i).getType());
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {

        return  categorylist.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView home_category_img;
        private TextView name;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            home_category_img=itemView.findViewById(R.id.home_category_item_image);
            name=itemView.findViewById(R.id.home_iteam_category_tv);
        }
    }


}
