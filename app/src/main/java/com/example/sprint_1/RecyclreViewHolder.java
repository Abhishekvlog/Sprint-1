package com.example.sprint_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class RecyclreViewHolder extends RecyclerView.ViewHolder {
    private  TextView mTitle,mStoryline  , mReleasingDate;
    private ImageView movieImage;

    public RecyclreViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.moviename);
        movieImage = itemView.findViewById(R.id.moveiimage);
        mStoryline= itemView.findViewById(R.id.StoryLine);
        mReleasingDate = itemView.findViewById(R.id.date);
    }
    public void setData(NowShowingDTO nowShowingDTO){
        mTitle.setText(nowShowingDTO.getTitle());
        Glide.with(movieImage).load(nowShowingDTO.getPosterurl()).into(movieImage);
        mStoryline.setText(nowShowingDTO.getStoryline());
        mReleasingDate.setText(nowShowingDTO.getReleaseDate());
    }
}
