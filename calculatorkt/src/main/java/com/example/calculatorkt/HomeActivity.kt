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
//        private lateinit var btn0: Button
//        private lateinit var btn1: Button
//        private lateinit var btn2: Button
//        private lateinit var btn3: Button
//        private lateinit var btn4: Button
//        private lateinit var btn5: Button
//        private lateinit var btn6: Button
//        private lateinit var btn7: Button
//        private lateinit var btn8: Button
//        private lateinit var btn9: Button
//        private lateinit var btnAC: Button
//        private lateinit var btnDel: Button
//        private lateinit var btnDivision: Button
//        private lateinit var btnMultiplication: Button
//        private lateinit var btnSubtraction: Button
//        private lateinit var btnAddition: Button
//        private lateinit var btnEquals: Button
//        private lateinit var btnDecimal: Button
        private var decimal_inserted = false; private var operator_inserted = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculation = binding.calculation
        result = binding.result

        curr = ""
        res = ""

        //buttons
        var btn0 = binding.btn0
        var btn1 = binding.btn1
        var btn2 = binding.btn2
        var btn3 = binding.btn3
        var btn4 = binding.btn4
        var btn5 = binding.btn5
        var btn6 = binding.btn6
        var btn7 = binding.btn7
        var btn8 = binding.btn8
        var btn9 = binding.btn9
        var btnDecimal = binding.btnDecimal
        var btnMultiplication = binding.btnMultiplication
        var btnDivision = binding.btnDivision
        var btnSubtraction = binding.btnSubtraction
        var btnAddition = binding.btnAddition
        var btnEquals = binding.btnEquals
        var btnAC = binding.btnAC
        var btnDel = binding.btnDel

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
                decimal_inserted = true
            }
            // check if decimal_inserted == false => append "."
            if (!decimal_inserted) {
                curr = "$curr."
                decimal_inserted = true
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
            decimal_inserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operator_inserted) {
                    curr = "$curr ÷ "
                    operator_inserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnMultiplication.setOnClickListener { // set decimal_inserted = false
            decimal_inserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operator_inserted) {
                    curr = "$curr * "
                    operator_inserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnSubtraction.setOnClickListener { // set decimal_inserted = false
            decimal_inserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operator_inserted) {
                    curr = "$curr - "
                    operator_inserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnAddition.setOnClickListener { // set decimal_inserted = false
            decimal_inserted = false
            // check if curr is not empty
            if (curr.isNotEmpty()) {
                // check if the last digit is dot => remove
                if (curr.substring(curr.length - 1, curr.length) == ".") {
                    backspace()
                }
                // check if operator_inserted == false => append operator to curr
                if (!operator_inserted) {
                    curr = "$curr + "
                    operator_inserted = true
                }
            }
            // displayOne()
            displayOne()
        }

        btnEquals.setOnClickListener {
            if (operator_inserted && curr.substring(curr.length - 1, curr.length) != " ") {
                Log.d(curr, "onClick: This is the substring before switch")
                val tokens = curr.split(" ").toTypedArray()
                when (tokens[1][0]) {
                    '+' -> res = java.lang.Double.toString(tokens[0].toDouble() + tokens[2].toDouble())
                    '-' -> res = java.lang.Double.toString(tokens[0].toDouble() - tokens[2].toDouble())
                    '*' -> res = java.lang.Double.toString(tokens[0].toDouble() * tokens[2].toDouble())
                    '÷' -> res = java.lang.Double.toString(tokens[0].toDouble() / tokens[2].toDouble())
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
        decimal_inserted = false
        operator_inserted = false
    }

    private fun backspace() {
        if (curr.isNotEmpty()) {

            // check if the dot is last char in curr => set dot_inserted = false
            if (curr.substring(curr.length - 1, curr.length) == ".") {
                decimal_inserted = false
            }

            // if operator is detected => delete three digits or chars from the curr & set operator_inserted = false
            if (curr.substring(curr.length - 1, curr.length) == " ") {
                curr = curr.substring(0, curr.length - 3)
                operator_inserted = false
            } else {
                curr = curr.substring(0, curr.length - 1)
            }
            curr = curr.substring(0, curr.length - 1)
        }
    }
}