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

import com.example.mygrocerystore.model.RecommandadModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecomandedAdapter extends RecyclerView.Adapter<RecomandedAdapter.ViewHolder> {

    private final Context context;
    private final List<RecommandadModel> list;

    public RecomandedAdapter(Context context, List<RecommandadModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recomanded_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int i) {

        viewHolder.name.setText(list.get(i).getName());
        viewHolder.descrpitom.setText(list.get(i).getDescription());
        viewHolder.ratginber.setText(list.get(i).getRathing());

        Glide.with(context).load(list.get(i).getImg_ur()).into(viewHolder.recomanded_img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView recomanded_img;
        private TextView name;
        private TextView descrpitom;
        private TextView ratginber;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            recomanded_img=itemView.findViewById(R.id.recomand_img);
            name=itemView.findViewById(R.id.recomand_name);
            descrpitom=itemView.findViewById(R.id.recomand_dec);
            ratginber=itemView.findViewById(R.id.recomand_rathingber);

        }
    }
}
