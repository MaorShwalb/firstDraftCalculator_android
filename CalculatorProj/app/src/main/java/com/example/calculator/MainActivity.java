package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double number1 = 0;
    double number2 = 0;
    String action = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView);
    }

    public void numberClickFunction(View view) {

        Button btn = (Button) view;
        String str = btn.getText().toString();

        result.append(str);

    }

/*    public void clearClickFunction(View view) {
        String str = "";
        number1 = 0;
        number2 = 0;
        action = null;
        result.setText(str);
    }*/


    public void actionClickFunction(View view) {

            number1 = Double.parseDouble(result.getText().toString());

            Button btn = (Button) view;
            action = btn.getText().toString();

            result.append(action);
            action = result.getText().toString().substring(result.length() - 1);
            result.setText("");
    }

    public void answerClickFunction(View view) {

        number2 = Double.parseDouble(result.getText().toString());

        if (action.equals("-")) {
            number1 -= number2;
        } else if (action.equals("+")) {
            number1 += number2;
        } else if (action.equals("X")) {
            number1 *= number2;
        } else if (action.equals("/")) {
            if (number2 == 0) {
                number1 = 0;
            } else {
                number1 /= number2;
            }
        }

        number2 = number1 - Math.floor(number1);


        if (number2 == 0) {
            result.setText(String.valueOf((int) number1));
        } else {
            result.setText(String.format("%.6f", number1));
        }

        action = null;
        number2 = 0;
    }

}
