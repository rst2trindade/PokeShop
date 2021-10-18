package br.com.rtd.pokeshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rtd.pokeshop.databinding.ActivityProductListBinding
import br.com.rtd.pokeshop.ui.adapter.ProductListActivityAdapter

class ProductListActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val recyclerView = binding.productListRecyclerview
        recyclerView.adapter = ProductListActivityAdapter()
    }

}