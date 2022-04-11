package com.example.basic_mvvm_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.basic_mvvm_fragment.databinding.ActivityMainBinding
import com.example.basic_mvvm_fragment.viewmodel.FragmentViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(FragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fragmentViewModel = viewModel
        binding.lifecycleOwner = this
    }
}