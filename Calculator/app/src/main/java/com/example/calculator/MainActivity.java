package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    TextView result;

    EditText activeInput;
    String operator = null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);

        input1.setShowSoftInputOnFocus(false);
        input2.setShowSoftInputOnFocus(false);

        input1.setOnClickListener(v -> activeInput = input1);
        input2.setOnClickListener(v -> activeInput = input2);

        TextView [] numbers = {
                findViewById(R.id.num0),
                findViewById(R.id.num1),
                findViewById(R.id.num2),
                findViewById(R.id.num3),
                findViewById(R.id.num4),
                findViewById(R.id.num5),
                findViewById(R.id.num6),
                findViewById(R.id.num7),
                findViewById(R.id.num8),
                findViewById(R.id.num9)

        };

        for (TextView num: numbers){
            num.setOnClickListener(v -> {
                if (activeInput != null){
                    activeInput.append(num.getText().toString());
                }
            });
        }

        TextView add = findViewById(R.id.plus);
        TextView minus = findViewById(R.id.minus);
        TextView multiply = findViewById(R.id.multiply);
        TextView devide = findViewById(R.id.divide);
        TextView equal = findViewById(R.id.equal);
        TextView clear = findViewById(R.id.clear);

        add.setOnClickListener(v -> operator = "+");
        minus.setOnClickListener(v -> operator = "-");
        multiply.setOnClickListener(v -> operator = "*");
        devide.setOnClickListener(v -> operator = "-");

        equal.setOnClickListener(v -> {
            if (!input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty() && operator != null){
                double num1 = Double.parseDouble(input1.getText().toString());
                double num2 = Double.parseDouble(input2.getText().toString());
                double res = 0;

                switch (operator){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0){
                            res = num1 / num2;
                        }else {
                            result.setText("Error");
                            return;
                        }
                        break;
                }

                result.setText(String.valueOf(res));
                operator = null;
            }
        });

        clear.setOnClickListener(v -> {
            input1.setText("");
            input2.setText("");
            result.setText("");
            operator = null;
            activeInput = null;
        });

    }
}