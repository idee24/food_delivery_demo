package com.example.food_delivery_demo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery_demo.R

/**
 *Created by Yerimah on 12/20/2020.
 */
class CheckoutAdapter(): RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checkout_list_item, parent, false)
        return CheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {

        holder.cancelImageView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = 8

    inner class CheckoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.checkoutItemImageView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val cancelImageView: ImageView = itemView.findViewById(R.id.cancelImageView)
    }
}