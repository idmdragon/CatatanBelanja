package com.example.catatanbelanja.data.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanbelanja.R
import com.example.catatanbelanja.data.db.entities.ShoppingItem
import com.example.catatanbelanja.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currItem = items[position]

        holder.itemView.tvName.text = currItem.Name
        holder.itemView.tvAmount.text = "${currItem.Amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currItem)
        }
        holder.itemView.ivAdd.setOnClickListener {
            currItem.Amount++
            viewModel.upsert(currItem)
        }
        holder.itemView.ivSubstract.setOnClickListener {
           if (currItem.Amount>0){
               currItem.Amount--
               viewModel.upsert(currItem)
           }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}