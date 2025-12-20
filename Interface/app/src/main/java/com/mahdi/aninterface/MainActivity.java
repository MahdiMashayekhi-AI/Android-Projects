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

public class MainActivity extends AppCompatActivity implements DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText first = findViewById(R.id.etFirst);
        EditText second = findViewById(R.id.etSecond);
        TextView btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            onSendData(first.getText().toString(), second.getText().toString());
        });

        Intent intent = getIntent();
        if (intent.hasExtra("first") || intent.hasExtra("second")){
            first.setText(intent.getStringExtra("first"));
            second.setText(intent.getStringExtra("second"));
        }

    }

    @Override
    public void onSendData(String first, String second) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("first", first);
        intent.putExtra("second", second);
        startActivity(intent);
    }
}