package com.example.sprint_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    private List<ComingSoonDTO> viewpagerList ;
    private ImageView ImagePoster;
    public ViewPagerAdapter(List<ComingSoonDTO> viewpagerList){
        this.viewpagerList = viewpagerList;
    }
    @Override
    public int getCount() {
        return viewpagerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_movie_details,null);
        ImagePoster = view.findViewById(R.id.moviePoster);
        Glide.with(context).load(viewpagerList.get(position).getPosterurl());
        container.addView(view);
        return view;
    }
}
