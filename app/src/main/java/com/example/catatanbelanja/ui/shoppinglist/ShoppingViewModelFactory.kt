@file:Suppress("UNCHECKED_CAST")

package com.example.catatanbelanja.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catatanbelanja.data.repositories.ShoppingRepostiories

class ShoppingViewModelFactory (
    private val repostiories: ShoppingRepostiories
):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repostiories) as T
    }
}