package com.example.mvvm_recyclerview_room.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvm_recyclerview_room.database.Product
import com.example.mvvm_recyclerview_room.database.ProductDatabase

class ProductRepositoryImpl(application: Application) : ProductRepository {
    private val productDao by lazy {
        ProductDatabase.getInstance(application)!!.productDao()
    }

    override suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    override suspend fun update(product: Product) {
        productDao.update(product)
    }

    override suspend fun delete(product: Product) {
        productDao.delete(product)
    }

    override fun getAll(): LiveData<List<Product>> {
        return productDao.getAll()

    }
}