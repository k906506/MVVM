package com.example.mvvm_recyclerview_room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvm_recyclerview_room.database.Product
import com.example.mvvm_recyclerview_room.repository.ProductRepositoryImpl

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ProductRepositoryImpl(application)
    private val products = repository.getAll()

    suspend fun insert(product: Product) {
        repository.insert(product)
    }

    suspend fun update(product: Product) {
        repository.update(product)
    }

    suspend fun delete(product: Product) {
        repository.delete(product)
    }

    fun getAll(): LiveData<List<Product>> {
        return products
    }
}