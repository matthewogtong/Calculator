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
        private lateinit var curr: String; lateinit var res: String
        private lateinit var btn0: Button
        private lateinit var btn1: Button
        private lateinit var btn2: Button
        private lateinit var btn3: Button
        private lateinit var btn4: Button
        private lateinit var btn5: Button
        private lateinit var btn6: Button
        private lateinit var btn7: Button
        private lateinit var btn8: Button
        private lateinit var btn9: Button
        private lateinit var btnAC: Button
        private lateinit var btnDel: Button
        private lateinit var btnDivision: Button
        private lateinit var btnMultiplication: Button
        private lateinit var btnSubtraction: Button
        private lateinit var btnAddition: Button
        private lateinit var btnEquals: Button
        private lateinit var btnDecimal: Button
        private var decimal_inserted = false; private var operator_inserted = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculation = binding.calculation
        result = binding.result

        var curr = ""
        var res = ""
        var decimal_inserted = false
        var operator_inserted = false

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

    }

    fun displayOne() {
        calculation.setText(curr)
    }
}