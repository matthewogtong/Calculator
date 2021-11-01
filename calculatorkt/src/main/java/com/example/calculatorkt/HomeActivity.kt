package com.example.calculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.calculatorkt.databinding.ActivityCalculatorBinding

class HomeActivity : AppCompatActivity() {

        private lateinit var binding: ActivityCalculatorBinding
        private lateinit var calculation: EditText; private lateinit var result: EditText
        private lateinit var curr: String; private lateinit var res: String
        private var decimalInserted = false; private var operatorInserted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculation = binding.calculation
        result = binding.result

        curr = ""
        res = ""

        //buttons
        val btn0 = binding.btn0
        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.btn3
        val btn4 = binding.btn4
        val btn5 = binding.btn5
        val btn6 = binding.btn6
        val btn7 = binding.btn7
        val btn8 = binding.btn8
        val btn9 = binding.btn9
        val btnDecimal = binding.btnDecimal
        val btnMultiplication = binding.btnMultiplication
        val btnDivision = binding.btnDivision
        val btnSubtraction = binding.btnSubtraction
        val btnAddition = binding.btnAddition
        val btnEquals = binding.btnEquals
        val btnAC = binding.btnAC
        val btnDel = binding.btnDel

        btn0.setOnClickListener {
            curr += "0"
            displayOne()
        }

        btn1.setOnClickListener {
            curr += "1"
            displayOne()
        }

        btn2.setOnClickListener {
            curr += "2"
            displayOne()
        }

        btn3.setOnClickListener {
            curr += "3"
            displayOne()
        }

        btn4.setOnClickListener {
            curr += "4"
            displayOne()
        }

        btn5.setOnClickListener {
            curr += "5"
            displayOne()
        }

        btn6.setOnClickListener {
            curr += "6"
            displayOne()
        }

        btn7.setOnClickListener {
            curr += "7"
            displayOne()
        }

        btn8.setOnClickListener {
            curr += "8"
            displayOne()
        }

        btn9.setOnClickListener {
            curr += "9"
            displayOne()
        }

        btnDecimal.setOnClickListener { // check if its empty => append "0." and set decimal_inserted variable to true
            if (curr.isEmpty()) {
                curr = "."
                decimalInserted = true
            }
            // check if decimal_inserted == false => append "."
            if (!decimalInserted) {
                curr = "$curr."
                decimalInserted = true
            }
            displayOne()
        }

        btnAC.setOnClickListener {
            clear()
            displayOne()
            displayTwo()
        }

        btnDel.setOnClickListener {
            backspace()
            displayOne()
        }

        btnDivision.setOnClickListener { // set decimal_inserted = false
            decimalInserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operatorInserted) {
                    curr = "$curr ÷ "
                    operatorInserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnMultiplication.setOnClickListener { // set decimal_inserted = false
            decimalInserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operatorInserted) {
                    curr = "$curr * "
                    operatorInserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnSubtraction.setOnClickListener { // set decimal_inserted = false
            decimalInserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operatorInserted) {
                    curr = "$curr - "
                    operatorInserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnAddition.setOnClickListener { // set decimal_inserted = false
            decimalInserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operatorInserted) {
                    curr = "$curr + "
                    operatorInserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnEquals.setOnClickListener {
            if (operatorInserted && curr.substring(curr.length - 1, curr.length) != " ") {
                Log.d(curr, "onClick: This is the substring before switch")
                val tokens = curr.split(" ").toTypedArray()
                when (tokens[1][0]) {
                    '+' -> res = (tokens[0].toDouble() + tokens[2].toDouble()).toString()
                    '-' -> res = (tokens[0].toDouble() - tokens[2].toDouble()).toString()
                    '*' -> res = (tokens[0].toDouble() * tokens[2].toDouble()).toString()
                    '÷' -> res = (tokens[0].toDouble() / tokens[2].toDouble()).toString()
                }
            }
            displayTwo()
        }

    }

    private fun displayOne() {
        calculation.setText(curr)
    }

    private fun displayTwo() {
        result.setText(res)
    }

    private fun clear() {
        curr = ""
        res = ""
        decimalInserted = false
        operatorInserted = false
    }

    private fun backspace() {
        if (curr.isNotEmpty()) {

            // check if the dot is last char in curr => set dot_inserted = false
            if (curr.substring(curr.length - 1, curr.length) == ".") {
                decimalInserted = false
            }

            // if operator is detected => delete three digits or chars from the curr & set operator_inserted = false
            if (curr.substring(curr.length - 1, curr.length) == " ") {
                curr = curr.substring(0, curr.length - 3)
                operatorInserted = false
            } else {
                curr = curr.substring(0, curr.length - 1)
            }
            curr = curr.substring(0, curr.length - 1)
        }
    }
}