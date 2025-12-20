package com.mahdi.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameText, phoneText;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameText = itemView.findViewById(R.id.nameText);
        phoneText = itemView.findViewById(R.id.phoneText);
    }
}
