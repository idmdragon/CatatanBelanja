package com.example.catatanbelanja.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.catatanbelanja.data.db.entities.ShoppingItem

//data access object
@Dao
interface ShoppingDao {
    //update insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * FROM SHOPPING_ITEM")
    fun getAllShoppingItem():LiveData<List<ShoppingItem>>
}