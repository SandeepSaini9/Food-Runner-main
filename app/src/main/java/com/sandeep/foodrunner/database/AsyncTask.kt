@file:Suppress("DEPRECATION")

package com.sandeep.foodrunner.database

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.room.Room

class DBAsyncTask(@SuppressLint("StaticFieldLeak") val context: Context, private val restaurantEntity: RestaurantEntity, private val mode: Int) :
    AsyncTask<Void, Void, Boolean>() {


    private val db =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db").build()

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg p0: Void?): Boolean {

        when (mode) {
            1 -> { //checkRestaurantById
                db.restaurantDao()
                    .getRestaurantById(restaurantEntity.id)
                db.close()
                return true
            }
            2 -> { //insertRestaurant
                db.restaurantDao().insertRestaurant(restaurantEntity)
                db.close()
                return true
            }
            3 -> { //deleteRestaurant
                db.restaurantDao().deleteRestaurant(restaurantEntity)
                db.close()
                return true
            }

            else -> return false

        }

    }


}

class FavAsyncTask(context: Context) :
    AsyncTask<Void, Void, List<RestaurantEntity>>() {
    private val db =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db").build()

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): List<RestaurantEntity> {

        return db.restaurantDao().getAllRestaurants()
    }
}

class CartAsyncTask(
    @SuppressLint("StaticFieldLeak") val context: Context,
    private val restaurantMenuEntity: RestaurantMenuEntity? = null,
    val id: String = "",
    val mode: Int,
) : AsyncTask<Void, Void, Boolean>() {

    private val db =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db").build()

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): Boolean {
        when (mode) {
            //insert
            1 -> {
                db.restaurantMenuDao().insertItemToCart(restaurantMenuEntity!!)
                db.close()
                return true
            }
            //remove
            2 -> {
                db.restaurantMenuDao().removeItemFromCart(restaurantMenuEntity!!)
                db.close()
                return true
            }
            //check if in cart
            3 -> {
                db.restaurantMenuDao().checkIfAddedToCart(id)
                db.close()
                return true
            }
            //delete all items
            4 -> {
                db.restaurantMenuDao().deleteAllCartItems()
                db.close()
                Log.d("TAG", "deleteAllCartItems: ")
                return true
            }
        }
        return false
    }

}


class CartItemsAsyncTask(
    @SuppressLint("StaticFieldLeak") val context: Context,
) : AsyncTask<Void, Void, List<RestaurantMenuEntity>>() {
    private val db =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db").build()

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): List<RestaurantMenuEntity> {
        val cartList = db.restaurantMenuDao().getCartContents()
        db.close()
        return cartList
    }

}


class CartTotalAsyncTask(@SuppressLint("StaticFieldLeak") val context: Context) :
    AsyncTask<Void, Void, Int>() {
    private val db =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db").build()

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): Int {
        val total = db.restaurantMenuDao().getCartTotal()
        db.close()
        return total
    }
}