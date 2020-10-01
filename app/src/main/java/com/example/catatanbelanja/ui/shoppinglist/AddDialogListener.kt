package com.example.catatanbelanja.ui.shoppinglist

import com.example.catatanbelanja.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item : ShoppingItem)
}