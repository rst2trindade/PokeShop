package br.com.rtd.pokeshop.model.entity

import android.util.Log

class Cart {

    private val cartItemArray = ArrayList<CartItem>()

    fun addItem(card: PokemonCard) {
        val cardtItem: CartItem? = cartItemArray.find {
            it.pokemonCard == card
        }
        if (cardtItem == null) {
            cartItemArray.add(CartItem(card, 1))
        } else {
            cardtItem.addCardsCount()
        }
    }

    fun removeItem(card: PokemonCard): Boolean {
        val cardtItem: CartItem? = cartItemArray.find {
            it.pokemonCard == card
        }
        Log.d("LISTA DE CARTAS",cartItemArray.toString())
        cardtItem?.removeCardsCount()
        if (cardtItem?.cardsCount == 0) {
            return cartItemArray.remove(cartItemArray.find { it.pokemonCard == card })
        }
        return false
    }

    fun returnAllCard(): List<CartItem> {
        return cartItemArray.toList()
    }
}