package br.com.rtd.pokeshop.model.entity

import android.os.Parcel
import br.com.rtd.pokeshop.model.enums.CardTypes
import java.math.BigDecimal

data class PokemonCard(
    val name: String,
    val valor: BigDecimal,
    val description: String,
    val type: CardTypes,
    val urlImagem: String? = null
){
            
}