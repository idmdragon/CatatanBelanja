package com.example.catatanbelanja.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.catatanbelanja.R
import com.example.catatanbelanja.data.db.ShoppingDatabase
import com.example.catatanbelanja.data.repositories.ShoppingRepostiories

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repositories = ShoppingRepostiories(database)
        val factory = ShoppingViewModelFactory(repositories)

        val viewModel = ViewModelProviders.of(this).get(ShoppingViewModel::class.java)
//            ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
    }
}