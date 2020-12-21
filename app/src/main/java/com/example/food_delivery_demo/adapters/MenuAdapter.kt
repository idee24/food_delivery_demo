package com.example.food_delivery_demo.adapters

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery_demo.R


/**
 *Created by Yerimah on 12/18/2020.
 */

class MenuAdapter(private val menuItems: ArrayList<MenuItem>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
//        items[position].let {
//            holder.itemImageView.setImageResource(it.itemImage)
//            holder.titleTextView.text = it.name
//            holder.descriptionTextView.text = it.description
//            holder.detailsTextView.text = it.itemDetails
//            holder.buttonTextView.text = it.amount.toString()
//        }

        holder.buttonTextView.setOnClickListener {
            holder.buttonTextView.setBackgroundResource(R.drawable.item_button_background_green)
            holder.buttonTextView.text = "added + 1"
        }
    }

    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
        val titleTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val detailsTextView: TextView = itemView.findViewById(R.id.detailsTextView)
        val buttonTextView: TextView = itemView.findViewById(R.id.buttonTextView)
    }
}