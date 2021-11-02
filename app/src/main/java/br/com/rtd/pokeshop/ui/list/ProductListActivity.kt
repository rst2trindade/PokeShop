package br.com.rtd.pokeshop.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.rtd.pokeshop.R
import br.com.rtd.pokeshop.dao.PokemonCardDao
import br.com.rtd.pokeshop.databinding.ActivityProductListBinding
import br.com.rtd.pokeshop.model.entity.PokemonCard
import br.com.rtd.pokeshop.ui.cart.ShoppingCartListActivity
import br.com.rtd.pokeshop.ui.description.DescriptionPokeCard
import br.com.rtd.pokeshop.ui.form.ProductRegisterActivity

class ProductListActivity : AppCompatActivity() {

    private val dao = PokemonCardDao()
    private val adapter = ProductListActivityAdapter(dao.returnAllCard(),this::goDescription)

    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyvlerView()

        binding.fabProductList.setOnClickListener {
            goRegisterActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.updateAdapter(dao.returnAllCard())
    }

    private fun configRecyvlerView() {
        val recyclerView = binding.productListRecyclerview
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_cart->{
                goShoppingCartList()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goShoppingCartList() {
        val intent = Intent(this, ShoppingCartListActivity::class.java)
        startActivity(intent)
    }

    private fun goRegisterActivity() {
        val intent = Intent(this, ProductRegisterActivity::class.java)
        startActivity(intent)
    }
    private fun goDescription(pokemonCard: PokemonCard) {
        val intent = Intent(this, DescriptionPokeCard::class.java).apply {
            putExtra("KEY_CARD", pokemonCard)
        }
        startActivity(intent)
    }
}
