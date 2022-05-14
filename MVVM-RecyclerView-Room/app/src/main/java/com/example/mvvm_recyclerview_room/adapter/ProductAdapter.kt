package com.example.mvvm_recyclerview_room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_recyclerview_room.database.Product
import com.example.mvvm_recyclerview_room.databinding.ItemMainBinding

class ProductAdapter(private val itemClickListener: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var products: List<Product>? = null

    inner class ViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(product: Product) {
            binding.itemTextView.text = product.title

            binding.btnRemove.setOnClickListener {
                itemClickListener(product)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        products?.let {
            holder.bindViews(it[position])
        }
    }

    override fun getItemCount(): Int {
        return products?.size ?: 0
    }

    fun submitList(items: List<Product>) {
        products = items
        notifyDataSetChanged()
    }
}