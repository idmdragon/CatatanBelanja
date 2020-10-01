package com.example.catatanbelanja.data.repositories

import com.example.catatanbelanja.data.db.ShoppingDatabase
import com.example.catatanbelanja.data.db.entities.ShoppingItem

class ShoppingRepostiories (
    private val db : ShoppingDatabase
){
    suspend fun upsert(item : ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item : ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem()= db.getShoppingDao().getAllShoppingItem()
}