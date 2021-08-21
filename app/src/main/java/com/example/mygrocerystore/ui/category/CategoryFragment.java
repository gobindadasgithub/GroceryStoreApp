package com.example.mygrocerystore.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygrocerystore.R;
import com.example.mygrocerystore.adapter.NavCategoryAdapter;
import com.example.mygrocerystore.model.NavCategoryModel;
import com.example.mygrocerystore.model.RecommandadModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CategoryFragment extends Fragment {

    private RecyclerView nav_category_rec;
    private NavCategoryAdapter navCategoryAdapter;
    private List<NavCategoryModel> navCategoryModelList;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View root= inflater.inflate(R.layout.fragment_category,container,false);

       nav_category_rec=root.findViewById(R.id.category_rec);
       navCategoryModelList=new ArrayList<>();
       nav_category_rec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
       navCategoryAdapter=new NavCategoryAdapter(navCategoryModelList,getActivity());
       nav_category_rec.setAdapter(navCategoryAdapter);


       firebaseFirestore.collection("NavCategory")
               .get()
               .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                   @Override
                   public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                       if (task.isSuccessful()){
                           for (DocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                               NavCategoryModel navCategoryModel=document.toObject(NavCategoryModel.class);
                              navCategoryModelList.add(navCategoryModel);
                             navCategoryAdapter.notifyDataSetChanged();

                           }

                       }else{
                           Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_SHORT).show();
                       }

                   }
               });


       return  root;
    }


}