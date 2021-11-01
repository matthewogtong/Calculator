package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.databinding.ActivityCalculatorBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityCalculatorBinding binding;
    private EditText calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDel, btnDivision, btnMultiplication, btnSubtraction, btnAddition, btnEquals, btnDecimal;
    private boolean decimal_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_calculator);

        calculation = findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        decimal_inserted = false;
        operator_inserted = false;

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

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if its empty => append "0." and set decimal_inserted variable to true
                if(curr.isEmpty()) {
                    curr = ".";
                    decimal_inserted = true;
                }
                // check if decimal_inserted == false => append "."
                if(decimal_inserted == false) {
                    curr = curr + ".";
                    decimal_inserted = true;
                }
                displayOne();
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
                displayOne();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set decimal_inserted = false
                decimal_inserted = false;
                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " ÷ ";
                        operator_inserted = true;
                    }
                }
                // displayOne()
                displayOne();
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set decimal_inserted = false
                decimal_inserted = false;
                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                // displayOne()
                displayOne();
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set decimal_inserted = false
                decimal_inserted = false;
                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                // displayOne()
                displayOne();
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set decimal_inserted = false
                decimal_inserted = false;
                // check if curr is not empty
                if (!curr.isEmpty()) {
                    // check if the last digit is dot => remove
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    // check if operator_inserted == false => append operator to curr
                    if (operator_inserted == false) {
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                // displayOne()
                displayOne();
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator_inserted==true && !curr.substring(curr.length()-1,curr.length()).equals(" ")) {
                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)) {
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                    }
                }
                displayTwo();
            }
        });
    }

    public void displayOne() {
        calculation.setText(curr);
    }

    public void displayTwo() {
        result.setText(res);
    }

    public void clear() {
        curr = "";
        res = "";
        decimal_inserted = false;
        operator_inserted = false;
    }

    public void backspace() {
        if(!curr.isEmpty()) {

            // check if the dot is last char in curr => set dot_inserted = false
            if(curr.substring(curr.length()-1, curr.length()).equals(".")) {
                decimal_inserted = false;
            }

            // if operator is detected => delete three digits or chars from the curr & set operator_inserted = false
            if(curr.substring(curr.length()-1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            } else {
                curr = curr.substring(0, curr.length()-1);
            }
            curr = curr.substring(0, curr.length()-1);
        }
    }

}