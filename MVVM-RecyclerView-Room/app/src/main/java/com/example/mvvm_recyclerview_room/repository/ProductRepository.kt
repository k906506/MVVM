package com.example.mvvm_recyclerview_room.repository

import androidx.lifecycle.LiveData
import com.example.mvvm_recyclerview_room.database.Product

interface ProductRepository {
    suspend fun insert(product: Product)

    suspend fun update(product: Product)

    suspend fun delete(product: Product)

    fun getAll(): LiveData<List<Product>>
}