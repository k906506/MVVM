package com.example.basic_mvvm_fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {
    private var _progress = MutableLiveData<Int>()

    var progress: MutableLiveData<Int> = _progress
        get() = _progress

    init {
        _progress.value = 0
    }
}