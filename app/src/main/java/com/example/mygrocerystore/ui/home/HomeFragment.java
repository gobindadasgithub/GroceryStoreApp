package com.example.mygrocerystore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygrocerystore.R;
import com.example.mygrocerystore.adapter.HomeCategoryAdapter;
import com.example.mygrocerystore.adapter.PopularAdapter;
import com.example.mygrocerystore.adapter.RecomandedAdapter;
import com.example.mygrocerystore.model.HomeCategoryModel;
import com.example.mygrocerystore.model.PopularModel;
import com.example.mygrocerystore.model.RecommandadModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {
  private   List<PopularModel> popularModelList=new ArrayList<>();
   private PopularAdapter popularAdapter;
  private   RecyclerView popular_rec;
   private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
     List<HomeCategoryModel> home_category_list;
     HomeCategoryAdapter home_category_Adapter;
    private  RecyclerView home_category_rec;


    private List<RecommandadModel> recomand_list;
    private RecomandedAdapter recomandedAdapter;
    private  RecyclerView recomadend_rec;

    private ProgressBar progressBar;
    private ScrollView scrollView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_home,container,false);

        popular_rec=root.findViewById(R.id.Pop_rec);
        home_category_rec=root.findViewById(R.id.explore_rec);
        recomadend_rec=root.findViewById(R.id.recommended_rec);
        progressBar=root.findViewById(R.id.progressber);
        scrollView=root.findViewById(R.id.scroll_view);
        try {
            progressBar.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollView.setVisibility(View.GONE);


        recomadend_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
      recomand_list=new ArrayList<>();
        recomandedAdapter=new RecomandedAdapter( getActivity(),recomand_list);
       recomadend_rec.setAdapter(recomandedAdapter);

        firebaseFirestore.collection("Recomanded")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            RecommandadModel recommandadModel=document.toObject(RecommandadModel.class);
                           recomand_list.add(recommandadModel);
                           recomandedAdapter.notifyDataSetChanged();

                        }
                    } else {
                        Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                });




        home_category_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        home_category_list=new ArrayList<>();
        home_category_Adapter=new HomeCategoryAdapter(home_category_list, getActivity());
        home_category_rec.setAdapter(home_category_Adapter);

        firebaseFirestore.collection("HomeCategory")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            HomeCategoryModel homecategoryModel=document.toObject(HomeCategoryModel.class);
                            home_category_list.add(homecategoryModel);
                            home_category_Adapter.notifyDataSetChanged();

                        }
                    } else {
                        Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                });




        popular_rec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        popularModelList=new ArrayList<>();
        popularAdapter=new PopularAdapter(getActivity(),popularModelList);
        popular_rec.setAdapter(popularAdapter);

        firebaseFirestore.collection("PopularProducts")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            PopularModel popularModel=document.toObject(PopularModel.class);
                            popularModelList.add(popularModel);
                            popularAdapter.notifyDataSetChanged();
                            try {
                                progressBar.setVisibility(View.GONE);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            scrollView.setVisibility(View.VISIBLE);


                        }
                    } else {
                        Toast.makeText(getActivity(),"Error"+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                });


        return root;


    }


}