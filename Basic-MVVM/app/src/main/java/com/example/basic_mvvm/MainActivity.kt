package com.example.basic_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.basic_mvvm.databinding.ActivityMainBinding
import com.example.basic_mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        increase()
        decrease()
    }

    private fun bindViews() {
        binding.displayNumberTextView.text = viewModel.getNumber().toString()
    }

    private fun increase() {
        binding.plusButton.setOnClickListener {
            viewModel.increase()
            binding.displayNumberTextView.text = viewModel.getNumber().toString()
        }
    }

    private fun decrease() {
        binding.minusButton.setOnClickListener {
            viewModel.decrease()
            binding.displayNumberTextView.text = viewModel.getNumber().toString()
        }
    }
}