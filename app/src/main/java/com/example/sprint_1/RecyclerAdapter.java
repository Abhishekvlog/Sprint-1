package com.example.sprint_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclreViewHolder> {
    private List<NowShowingDTO> nowShowingList;

    public RecyclerAdapter( List<NowShowingDTO> nowShowingList) {

        this.nowShowingList = nowShowingList;
    }

    @NonNull
    @Override
    public RecyclreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home,parent,false);
        return new RecyclreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclreViewHolder holder, int position) {
        NowShowingDTO nowShowingDTO = nowShowingList.get(position);
        holder.setData(nowShowingDTO);
    }

    @Override
    public int getItemCount() {
        return nowShowingList.size();
    }
}
