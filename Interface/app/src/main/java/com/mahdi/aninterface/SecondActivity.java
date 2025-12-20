package com.mahdi.aninterface;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity implements DataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String first = getIntent().getStringExtra("first");
        String second = getIntent().getStringExtra("second");

        EditText etFirst = findViewById(R.id.etFirst);
        EditText etSecond = findViewById(R.id.etSecond);
        TextView btnBack = findViewById(R.id.btnBack);

        etFirst.setText(first);
        etSecond.setText(second);

        btnBack.setOnClickListener(v -> {
            onSendData(etFirst.getText().toString(), etSecond.getText().toString());
        });
    }

    @Override
    public void onSendData(String first, String second) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        intent.putExtra("first", first);
        intent.putExtra("second", second);
        startActivity(intent);
    }
}