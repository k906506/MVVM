package com.example.mvvm_recyclerview_room.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM product")
    fun getAll(): LiveData<List<Product>>
}