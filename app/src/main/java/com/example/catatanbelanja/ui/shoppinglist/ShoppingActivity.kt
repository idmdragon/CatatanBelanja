package com.example.catatanbelanja.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catatanbelanja.R
import com.example.catatanbelanja.data.db.ShoppingDatabase
import com.example.catatanbelanja.data.db.entities.ShoppingItem
import com.example.catatanbelanja.data.other.ShoppingItemAdapter
import com.example.catatanbelanja.data.repositories.ShoppingRepostiories
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repositories = ShoppingRepostiories(database)
        val factory = ShoppingViewModelFactory(repositories)

        val viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)
        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        rvShoppingList.layoutManager= LinearLayoutManager(this)
        rvShoppingList.adapter = adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fAB.setOnClickListener {
            AddShoppingItemDialog(this,
            object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }


    }
}