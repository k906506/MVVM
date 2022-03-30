package com.example.basic_mvvm.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var num: Int = 0

    fun getNumber(): Int = num

    fun increase() = num++;

    fun decrease() = num--;
}