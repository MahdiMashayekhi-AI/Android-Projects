package com.mahdi.practice_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdaptor extends RecyclerView.Adapter<MusicAdaptor.ViewHolder> {
    private List<MusicItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(MusicItem item);
    }

    public MusicAdaptor(List<MusicItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MusicAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdaptor.ViewHolder holder, int position) {
        holder.textTitle.setText(items.get(position).getTitle());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(items.get(position)));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
