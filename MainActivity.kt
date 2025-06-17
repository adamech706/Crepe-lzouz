package com.crepelzouz.app

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etOrders: EditText
    lateinit var etOrderPrice: EditText
    lateinit var etOvertimeOrders: EditText
    lateinit var etOvertimePrice: EditText
    lateinit var etMonths: EditText
    lateinit var etMonthlyExpense: EditText

    lateinit var tvMonthlyProfit: TextView
    lateinit var tvOvertimeIncome: TextView
    lateinit var tvTotalMonthlyIncome: TextView
    lateinit var tvTotalYearlyIncome: TextView
    lateinit var tvTotalYearlyExpense: TextView
    lateinit var tvYearlySavings: TextView

    lateinit var btnCalculate: Button
    lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etOrders = findViewById(R.id.etOrders)
        etOrderPrice = findViewById(R.id.etOrderPrice)
        etOvertimeOrders = findViewById(R.id.etOvertimeOrders)
        etOvertimePrice = findViewById(R.id.etOvertimePrice)
        etMonths = findViewById(R.id.etMonths)
        etMonthlyExpense = findViewById(R.id.etMonthlyExpense)

        tvMonthlyProfit = findViewById(R.id.tvMonthlyProfit)
        tvOvertimeIncome = findViewById(R.id.tvOvertimeIncome)
        tvTotalMonthlyIncome = findViewById(R.id.tvTotalMonthlyIncome)
        tvTotalYearlyIncome = findViewById(R.id.tvTotalYearlyIncome)
        tvTotalYearlyExpense = findViewById(R.id.tvTotalYearlyExpense)
        tvYearlySavings = findViewById(R.id.tvYearlySavings)

        btnCalculate = findViewById(R.id.btnCalculate)
        btnReset = findViewById(R.id.btnReset)

        btnCalculate.setOnClickListener {
            calculateIncome()
        }

        btnReset.setOnClickListener {
            resetFields()
        }
    }

    private fun calculateIncome() {
        try {
            val orders = etOrders.text.toString().toInt()
            val orderPrice = etOrderPrice.text.toString().toDouble()
            val overtimeOrders = etOvertimeOrders.text.toString().toInt()
            val overtimePrice = etOvertimePrice.text.toString().toDouble()
            val months = etMonths.text.toString().toInt()
            val monthlyExpense = etMonthlyExpense.text.toString().toDouble()

            val monthlyProfit = orders * orderPrice
            val overtimeIncome = overtimeOrders * overtimePrice
            val totalMonthlyIncome = monthlyProfit + overtimeIncome
            val totalYearlyIncome = totalMonthlyIncome * months
            val totalYearlyExpense = monthlyExpense * months
            val yearlySavings = totalYearlyIncome - totalYearlyExpense

            tvMonthlyProfit.text = "الربح الشهري: ${'$'}{String.format("%.2f", monthlyProfit)}"
            tvOvertimeIncome.text = "دخل الـ overtime: ${'$'}{String.format("%.2f", overtimeIncome)}"
            tvTotalMonthlyIncome.text = "الدخل الشهري الكلي: ${'$'}{String.format("%.2f", totalMonthlyIncome)}"
            tvTotalYearlyIncome.text = "الدخل السنوي الكلي: ${'$'}{String.format("%.2f", totalYearlyIncome)}"
            tvTotalYearlyExpense.text = "المصروف السنوي: ${'$'}{String.format("%.2f", totalYearlyExpense)}"
            tvYearlySavings.text = "الادخار السنوي: ${'$'}{String.format("%.2f", yearlySavings)}"

        } catch (e: Exception) {
            Toast.makeText(this, "يرجى إدخال جميع القيم بشكل صحيح", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetFields() {
        etOrders.text.clear()
        etOrderPrice.text.clear()
        etOvertimeOrders.text.clear()
        etOvertimePrice.text.clear()
        etMonths.text.clear()
        etMonthlyExpense.text.clear()

        tvMonthlyProfit.text = ""
        tvOvertimeIncome.text = ""
        tvTotalMonthlyIncome.text = ""
        tvTotalYearlyIncome.text = ""
        tvTotalYearlyExpense.text = ""
        tvYearlySavings.text = ""
    }
}
