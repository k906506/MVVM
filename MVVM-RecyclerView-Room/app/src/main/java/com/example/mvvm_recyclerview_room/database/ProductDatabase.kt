package com.example.mvvm_recyclerview_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var instance: ProductDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ProductDatabase? {
            if (instance == null) {
                synchronized(ProductDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductDatabase::class.java,
                        "product-database"
                    ).build()
                }
            }
            return instance
        }
    }
}