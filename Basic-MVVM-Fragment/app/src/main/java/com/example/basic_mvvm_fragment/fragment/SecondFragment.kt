package com.example.basic_mvvm_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.basic_mvvm_fragment.R
import com.example.basic_mvvm_fragment.databinding.FragmentSecondBinding
import com.example.basic_mvvm_fragment.viewmodel.FragmentViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private val viewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(FragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        binding.fragmentViewModel = viewModel
        binding.lifecycleOwner = requireActivity()

        bindViews()

        return binding.root
    }

    private fun bindViews() {
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.progress.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit

        })
    }
}