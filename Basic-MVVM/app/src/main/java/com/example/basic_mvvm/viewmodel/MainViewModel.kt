package com.example.basic_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var num = MutableLiveData<Int>()

    init {
        num.value = 0
    }

    fun getNumber() = num

    fun increase() {
        num.value = num.value?.plus(1)
    }

    fun decrease() {
        num.value = num.value?.minus(1)
    }
}