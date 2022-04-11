package com.example.basic_mvvm_fragment.fragment

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.basic_mvvm_fragment.R
import com.example.basic_mvvm_fragment.databinding.FragmentFirstBinding
import com.example.basic_mvvm_fragment.viewmodel.FragmentViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    private val viewModel by lazy {
        ViewModelProviders.of(requireActivity()).get(FragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        binding.fragmentViewModel = viewModel
        binding.lifecycleOwner = requireActivity()

        bindViews()

        return binding.root
    }

    private fun bindViews() {
        binding.button.setOnClickListener {
            viewModel.progress.value = binding.numberEditTextView.text.toString().toInt()

            removeKeyboard()
        }
    }

    private fun removeKeyboard() {
        val manager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(binding.numberEditTextView.windowToken, 0)
    }
}