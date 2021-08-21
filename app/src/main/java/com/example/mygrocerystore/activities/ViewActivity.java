package com.example.mygrocerystore.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.mygrocerystore.R;
import com.example.mygrocerystore.adapter.ViewAllAdapter;
import com.example.mygrocerystore.model.RecommandadModel;
import com.example.mygrocerystore.model.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
RecyclerView view_all_rec;
List<ViewAllModel> viewAllModelList;
ViewAllAdapter viewAllAdapter;
FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        String type=getIntent().getStringExtra("type");
        view_all_rec=findViewById(R.id.View_all_rec);
        viewAllModelList=new ArrayList<>();
        view_all_rec.setLayoutManager(new LinearLayoutManager(this));
        viewAllAdapter=new ViewAllAdapter(viewAllModelList,this);
        view_all_rec.setAdapter(viewAllAdapter);

        try {
            toolbar=findViewById(R.id.Viewall_toolbar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (type!=null&& type.equalsIgnoreCase("friuit")){
firebaseFirestore.collection("AllProducts")
            .whereEqualTo("type","friuit")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult()){
                     ViewAllModel viewAllModel=documentSnapshot.toObject(ViewAllModel.class);
                     viewAllModelList.add(viewAllModel);
                     viewAllAdapter.notifyDataSetChanged();
                    }


                }
            });

        }
        if (type!=null&& type.equalsIgnoreCase("vegatable")){
            firebaseFirestore.collection("AllProducts")
                    .whereEqualTo("type","vegatable")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                            for (DocumentSnapshot documentSnapshot:task.getResult()){
                                ViewAllModel viewAllModel=documentSnapshot.toObject(ViewAllModel.class);
                                viewAllModelList.add(viewAllModel);
                                viewAllAdapter.notifyDataSetChanged();
                            }


                        }
                    });

        }



        if (type!=null&& type.equalsIgnoreCase("fish")){
            firebaseFirestore.collection("AllProducts")
                    .whereEqualTo("type","fish")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                            for (DocumentSnapshot documentSnapshot:task.getResult()){
                                ViewAllModel viewAllModel=documentSnapshot.toObject(ViewAllModel.class);
                                viewAllModelList.add(viewAllModel);
                                viewAllAdapter.notifyDataSetChanged();
                            }


                        }
                    });

        }

        if (type!=null&& type.equalsIgnoreCase("milk")){
            firebaseFirestore.collection("AllProducts")
                    .whereEqualTo("type","milk")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                            for (DocumentSnapshot documentSnapshot:task.getResult()){
                                ViewAllModel viewAllModel=documentSnapshot.toObject(ViewAllModel.class);
                                viewAllModelList.add(viewAllModel);
                                viewAllAdapter.notifyDataSetChanged();
                            }


                        }
                    });

        }
        if (type!=null&& type.equalsIgnoreCase("egg")){
            firebaseFirestore.collection("AllProducts")
                    .whereEqualTo("type","egg")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                            for (DocumentSnapshot documentSnapshot:task.getResult()){
                                ViewAllModel viewAllModel=documentSnapshot.toObject(ViewAllModel.class);
                                viewAllModelList.add(viewAllModel);
                                viewAllAdapter.notifyDataSetChanged();
                            }


                        }
                    });

        }






    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


}