package com.example.basic_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.basic_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        increase()
        decrease()
    }

    private fun bindViews() {
        binding.displayNumberTextView.text = num.toString()
    }

    private fun increase() {
        binding.plusButton.setOnClickListener {
            num += 1
            binding.displayNumberTextView.text = num.toString()
        }
    }

    private fun decrease() {
        binding.minusButton.setOnClickListener {
            num -= 1
            binding.displayNumberTextView.text = num.toString()
        }
    }
}