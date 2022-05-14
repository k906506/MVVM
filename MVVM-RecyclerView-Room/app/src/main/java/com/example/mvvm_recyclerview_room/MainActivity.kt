package com.example.mvvm_recyclerview_room

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_recyclerview_room.adapter.ProductAdapter
import com.example.mvvm_recyclerview_room.base.BaseActivity
import com.example.mvvm_recyclerview_room.database.Product
import com.example.mvvm_recyclerview_room.databinding.ActivityMainBinding
import com.example.mvvm_recyclerview_room.viewmodel.ProductViewModel
import kotlinx.coroutines.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by lazy {
        ViewModelProvider(this)[ProductViewModel::class.java]
    }

    private val adapter by lazy {
        ProductAdapter(itemClickListener = { product ->
            deleteProduct(product)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        bindViews()
        subscribeObserver()
    }

    private fun initViews() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
    }

    private fun bindViews() = with(binding) {
        btnAdd.setOnClickListener {
            insertProduct(editTextView.text.toString())
        }
    }

    private fun subscribeObserver() {
        viewModel.getAll().observe(this) { adapter.submitList(it) }
    }

    private fun insertProduct(title: String) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.insert(Product(id = null, title = title))
        }
    }

    private fun deleteProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.delete(product)
        }
    }

}