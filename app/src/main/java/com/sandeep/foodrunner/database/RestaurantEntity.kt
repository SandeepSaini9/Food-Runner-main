package com.sandeep.foodrunner.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Restaurants")
data class RestaurantEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val rating: Float,
    val price: Int,
    val image: String


)
