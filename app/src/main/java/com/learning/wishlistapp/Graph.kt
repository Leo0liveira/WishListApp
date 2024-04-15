package com.learning.wishlistapp

import android.content.Context
import androidx.room.Room
import com.learning.wishlistapp.data.WishDatabase
import com.learning.wishlistapp.data.WishRepository

object Graph {
    lateinit var database : WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}