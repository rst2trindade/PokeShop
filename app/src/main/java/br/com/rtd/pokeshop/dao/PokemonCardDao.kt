package br.com.rtd.pokeshop.dao

import br.com.rtd.pokeshop.model.entity.PokemonCard

class PokemonCardDao {

    fun addCard(card: PokemonCard){
        pokemonCards.add(card)
    }

    fun returnAllCard(): List<PokemonCard>{
        return pokemonCards.toList()
    }

    companion object{
        private val pokemonCards = mutableListOf<PokemonCard>()
    }
}