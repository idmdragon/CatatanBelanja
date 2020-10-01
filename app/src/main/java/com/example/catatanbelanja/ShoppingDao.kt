package com.example.catatanbelanja

import androidx.lifecycle.LiveData
import androidx.room.*

//data access object
@Dao
interface ShoppingDao {
    //update insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * FROM SHOPPING_ITEM")
    fun getAllShopping():LiveData<List<ShoppingItem>>
}