package com.example.food_delivery_demo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.networking.MenuItem

/**
 *Created by Yerimah on 12/20/2020.
 */
class CheckoutAdapter(private val context: Context,
                      private val checkoutItems: List<MenuItem>): RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checkout_list_item, parent, false)
        return CheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {

        checkoutItems[position].let {
            holder.itemNameTextView.text = it.name
            holder.priceTextView.text = it.amount.toString()
            Glide.with(context).load(it.itemImageUrl).placeholder(R.drawable.t).error(R.drawable.t).into(holder.imageView)
        }
        holder.cancelImageView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = checkoutItems.size

    inner class CheckoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.checkoutItemImageView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val cancelImageView: ImageView = itemView.findViewById(R.id.cancelImageView)
    }
}