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
        setContentView(binding.root)

        binding.bindingMainViewModel = viewModel
        binding.lifecycleOwner = this

// activity_main에서 onClick 으로 처리하여 아래 코드도 사용할 필요가 없어짐
//        increase()
//        decrease()
    }
//
//    private fun increase() {
//        binding.plusButton.setOnClickListener {
//            viewModel.increase()
//        }
//    }
//
//    private fun decrease() {
//        binding.minusButton.setOnClickListener {
//            viewModel.decrease()
//        }
//    }
}