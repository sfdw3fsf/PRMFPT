package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText number1EditText, number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.ADD);
            }
        });

        Button subtractButton = findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SUBTRACT);
            }
        });

        Button multiplyButton = findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MULTIPLY);
            }
        });

        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.DIVIDE);
            }
        });
    }

    private void performOperation(Operation operation) {
        String number1String = number1EditText.getText().toString();
        String number2String = number2EditText.getText().toString();

        if (!number1String.isEmpty() && !number2String.isEmpty()) {
            double number1 = Double.parseDouble(number1String);
            double number2 = Double.parseDouble(number2String);
            double result = 0;

            switch (operation) {
                case ADD:
                    result = number1 + number2;
                    break;
                case SUBTRACT:
                    result = number1 - number2;
                    break;
                case MULTIPLY:
                    result = number1 * number2;
                    break;
                case DIVIDE:
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        resultTextView.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            resultTextView.setText(String.valueOf(result));
        } else {
            resultTextView.setText("Please enter both numbers");
        }
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}