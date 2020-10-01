package com.example.catatanbelanja.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.catatanbelanja.data.db.entities.ShoppingItem
import com.example.catatanbelanja.data.repositories.ShoppingRepostiories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel (
    private val repostiories: ShoppingRepostiories
):ViewModel(){

    fun upsert(item : ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repostiories.upsert(item)
    }
    fun delete (item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repostiories.delete(item)
    }

    fun getAllShoppingItem()=repostiories.getAllShoppingItem()
}