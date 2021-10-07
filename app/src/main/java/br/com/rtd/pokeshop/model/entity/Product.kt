package br.com.rtd.pokeshop.model.entity

import br.com.rtd.pokeshop.model.enums.CardTypes
import java.math.BigDecimal

data class Product(
    val name: String,
    val valor: BigDecimal,
    val description: String,
    val type: CardTypes
) {
            
}