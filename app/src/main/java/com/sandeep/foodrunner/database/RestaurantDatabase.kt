package com.sandeep.foodrunner.database

import androidx.room.*

@Database(entities = [RestaurantEntity::class,RestaurantMenuEntity::class],version = 1)
abstract class RestaurantDatabase: RoomDatabase() {
    abstract fun restaurantDao():RestaurantDao

    abstract fun restaurantMenuDao(): RestaurantMenuDao
}

