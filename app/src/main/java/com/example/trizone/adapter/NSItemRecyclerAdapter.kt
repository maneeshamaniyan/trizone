package com.example.trizone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trizone.R
import com.example.trizone.data.NSItemsViewModel

/*Created by Maneesha on 9/01/2022*/

class NSItemRecyclerAdapter(private val itemList: List<NSItemsViewModel>) :
    RecyclerView.Adapter<NSItemRecyclerAdapter.ItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemsViewModel = itemList[position]
        holder.itemImageView.setImageResource(itemsViewModel.image)
        holder.itemNameTextView.text = itemsViewModel.itemName
        holder.itemPriceTextView.text = itemsViewModel.price.toString()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val itemPriceTextView: TextView = itemView.findViewById(R.id.priceTextView)
    }
}