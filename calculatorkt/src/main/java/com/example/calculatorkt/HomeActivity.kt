package com.example.calculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.example.calculatorkt.databinding.ActivityCalculatorBinding

class HomeActivity : AppCompatActivity() {

        private lateinit var binding: ActivityCalculatorBinding
        private lateinit var calculation: EditText; lateinit var result: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculation = binding.calculation
        result = binding.result

        val curr = ""
        val res = ""
        val decimal_inserted = false
        val operator_inserted = false

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
}