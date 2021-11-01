package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDel, btnDivision, btnMultiplication, btnSubtraction, btnAddition, btnEquals, btnDecimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calculation = findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnDel = (Button) findViewById(R.id.btnDel);

        displayOne();
        displayTwo();
    }

    public void displayOne() {
        curr = "2x3";
        calculation.setText(curr);
    }

    public void displayTwo() {
        res = "6";
        result.setText(res);
    }

}