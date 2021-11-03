package br.com.rtd.pokeshop.dao

import br.com.rtd.pokeshop.model.entity.Cart
import br.com.rtd.pokeshop.model.entity.CartItem
import br.com.rtd.pokeshop.model.entity.PokemonCard

class CartDao {
    fun addCard(card: PokemonCard){
        cart.addItem(card)
    }

    fun removeCard(card: PokemonCard):Boolean{
        return cart.removeItem(card)
    }

    fun returnAllCard(): List<CartItem> = cart.returnAllCard()

    companion object{
        private val cart = Cart()
    }
}