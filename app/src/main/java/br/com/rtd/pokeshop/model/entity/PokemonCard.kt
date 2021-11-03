package br.com.rtd.pokeshop.model.entity

import br.com.rtd.pokeshop.model.enums.CardTypes
import java.io.Serializable
import java.math.BigDecimal

data class PokemonCard(
    val name: String ="",
    val valor: BigDecimal= BigDecimal.ZERO,
    val description: String ="",
    val type: CardTypes?=null,
    val urlImagem: String? = null
):Serializable{
}