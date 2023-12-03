package com.example.calculatorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    @SuppressLint("SetTextI18n")
    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentInput = inputEditText.getText().toString();
        inputEditText.setText(currentInput + buttonText);
        // Handle numeric input, you can append the text to your input string
    }
    public void onBackspaceButtonClick(View view) {
        String currentInput = inputEditText.getText().toString();
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            inputEditText.setText(currentInput);
        }
    }

    public void onEqualButtonClick(View view) {
        performCalculation();
    }

    private void performCalculation() {
    }

    public void onDecButtonClick(View view) {
        performConversion(10, "Decimal");
        // Handle conversion to Decimal
        displayResult();
    }

    public void onBinButtonClick(View view) {
        performConversion(2, "Binary");
        // Handle conversion to Binary
        displayResult();
    }

    public void onOctButtonClick(View view) {
        performConversion(8, "Octal");
        // Handle conversion to Octal
        displayResult();
    }

    public void onHexButtonClick(View view) {
        performConversion(16, "Hexadecimal");
        // Handle conversion to Hexadecimal
        displayResult();
    }

    private void performConversion(int base, String baseName) {
        try {
            String inputString = inputEditText.getText().toString();
            if (!inputString.isEmpty()) {
                long result;
                if (base == 16) {
                    long inputValue = Long.parseLong(inputString, 16);
                    displayResult(inputValue, baseName);
                } else {
                    int inputValue = Integer.parseInt(inputString, base);
                    displayResult(inputValue, baseName);
                }
            } else {
                resultTextView.setText("Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input for conversion.");
        }
    }

    private void displayResult() {
        // Implement the displayResult method based on your requirements
    }

    private void displayResult(long result, String baseName) {
        resultTextView.setText("The " + baseName + " equivalent is: " + result);
    }
}

