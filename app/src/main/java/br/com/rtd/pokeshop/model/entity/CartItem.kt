package br.com.rtd.pokeshop.model.entity

import java.math.BigDecimal

data class CartItem(
    val pokemonCard: PokemonCard,
    var cardsCount: Int,
) {
    fun getTotal():BigDecimal = pokemonCard.valor * cardsCount.toBigDecimal()

    fun addCardsCount(){
        cardsCount++
    }

    fun removeCardsCount(){
        cardsCount--
    }
}