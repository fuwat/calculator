package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hw1.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    val firstNumber: Double? get() = binding.firstNumberEditText.text.toString().toDoubleOrNull()

    val secondNumber: Double? get() = binding.secondNumberEditText.text.toString().toDoubleOrNull()

    fun calculate(view: View) {
        if (firstNumber == null || secondNumber == null) {
            return
        }
        val result: Double = when (view.id) {
            R.id.addButton -> firstNumber!! + secondNumber!!
            R.id.subtractButton -> firstNumber!! - secondNumber!!
            R.id.multiplyButton -> firstNumber!! * secondNumber!!
            R.id.divideButton -> firstNumber!! / secondNumber!!
            else -> 0.0
        }
        binding.resultText.text = String.format("Result: %.2f", result)
    }

}