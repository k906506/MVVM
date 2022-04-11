package com.example.basic_mvvm_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.basic_mvvm_fragment.R
import com.example.basic_mvvm_fragment.databinding.FragmentFourthBinding
import com.example.basic_mvvm_fragment.viewmodel.FragmentViewModel

class FourthFragment : Fragment() {
    private lateinit var binding: FragmentFourthBinding

    private val viewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(FragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fourth, container, false)
        binding.fragmentViewModel = viewModel
        binding.lifecycleOwner = requireActivity()

        return binding.root
    }
}