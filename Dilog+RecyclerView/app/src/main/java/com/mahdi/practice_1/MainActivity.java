package com.mahdi.practice_1;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdaptor userAdaptor;
    private List<DataModel> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        userList = new ArrayList<>();
        userList.add(new DataModel("علی", 25, "ic_launcher_background"));
        userList.add(new DataModel("مریم", 22, "ic_launcher_background"));
        userList.add(new DataModel("رضا", 30, "ic_launcher_background"));
        userList.add(new DataModel("سارا", 28, "ic_launcher_background"));
        userList.add(new DataModel("محمد", 35, "ic_launcher_background"));

        userAdaptor = new UserAdaptor(this, userList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdaptor);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.DefaultItemAnimator());
    }
}