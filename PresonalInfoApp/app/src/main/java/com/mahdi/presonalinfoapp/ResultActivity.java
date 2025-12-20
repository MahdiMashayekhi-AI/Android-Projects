package com.mahdi.presonalinfoapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView name, family, age, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        name = findViewById(R.id.tvName);
        family = findViewById(R.id.tvFamily);
        age = findViewById(R.id.tvAge);
        phone = findViewById(R.id.tvPhone);

        UserModel user = getIntent().getParcelableExtra("user_data");

        if (user != null){
            name.setText(user.name);
            family.setText(user.family);
            age.setText(String.valueOf(user.age));
            phone.setText(user.phone);
        }

    }
}