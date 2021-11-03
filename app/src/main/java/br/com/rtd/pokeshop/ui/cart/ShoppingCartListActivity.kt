package br.com.rtd.pokeshop.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.rtd.pokeshop.dao.CartDao
import br.com.rtd.pokeshop.databinding.ActivityShoppingCartListBinding
import br.com.rtd.pokeshop.model.entity.PokemonCard

class ShoppingCartListActivity : AppCompatActivity() {

    private val dao = CartDao()
    private val adapter =
        ShoppingCartListActivityAdapter(dao.returnAllCard(), this::addItem, this::removeItem)

    private val binding by lazy {
        ActivityShoppingCartListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Carrinho"

        configRecyclerView()
    }


    private fun configRecyclerView() {
        val recyclerView = binding.shoppingCardListRecyclerview
        recyclerView.adapter = adapter
    }

    private fun addItem(card: PokemonCard) {
        dao.addCard(card)
    }

    private fun removeItem(card: PokemonCard):Boolean{
        return dao.removeCard(card)
    }
}