package com.mahdi.practice_1;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<ViewHolder> {
    private List<DataModel> userList;
    private Context context;

    public UserAdaptor(Context context, List<DataModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view, this::showDeleteDialog);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DataModel user = userList.get(i);

        viewHolder.tvName.setText(user.getName());
        viewHolder.tvAge.setText(String.valueOf(user.getAge()));
        int imageResource = viewHolder.itemView.getContext().getResources()
                .getIdentifier(user.getImage(), "drawable", viewHolder.itemView.getContext().getPackageName());

        if (imageResource != 0) {
            viewHolder.ivProfile.setImageResource(imageResource);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    private void showDeleteDialog(int position){
        new AlertDialog.Builder(context)
                .setTitle("Delete user?!")
                .setMessage("Are you sure you want to delete this user?")
                .setPositiveButton("Yes", ((dialog, which) -> {
                    userList.remove(position);
                    notifyItemRemoved(position);
                }))
                .setNegativeButton("No", ((dialog, which) -> {
                    dialog.dismiss();
                })).show();
    }
}
