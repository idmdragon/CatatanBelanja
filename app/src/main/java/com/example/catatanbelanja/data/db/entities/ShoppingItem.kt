package com.example.catatanbelanja.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var Name : String,
    @ColumnInfo(name = "item_amount")
    var Amount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var Id : Int? = null
}