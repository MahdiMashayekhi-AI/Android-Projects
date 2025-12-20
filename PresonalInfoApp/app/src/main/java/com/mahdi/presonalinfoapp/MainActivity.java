package com.mahdi.presonalinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name, family, age, phone;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.etName);
        family = findViewById(R.id.etFamily);
        age = findViewById(R.id.etAge);
        phone = findViewById(R.id.etPhone);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            UserModel userModel = new UserModel(
                    name.getText().toString(),
                    family.getText().toString(),
                    phone.getText().toString(),
                    Integer.parseInt(age.getText().toString())
            );

            intent.putExtra("user_data", userModel);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Successful! Goes to result.", Toast.LENGTH_LONG).show();

        });

    }
}