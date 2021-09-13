package com.example.sprint_1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<ComingSoonDTO> viewpagerList ;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private List<NowShowingDTO> nowShowingList;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);

        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<List<NowShowingDTO>> call = apiService.getMovie();
        call.enqueue(new Callback<List<NowShowingDTO>>() {
            @Override
            public void onResponse(Call<List<NowShowingDTO>> call, Response<List<NowShowingDTO>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK){
                    nowShowingList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<NowShowingDTO>> call, Throwable t) {

            }
        });


    }

    private void setRecyclerView() {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter((List<NowShowingDTO>) nowShowingList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
//    private void setMovieAdapter(List<ComingSoonDTO> viewpagerList){
//        viewPagerAdapter =
//    }
}