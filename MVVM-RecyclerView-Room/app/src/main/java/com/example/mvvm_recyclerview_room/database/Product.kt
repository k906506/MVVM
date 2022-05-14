package com.example.mvvm_recyclerview_room.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String
)
