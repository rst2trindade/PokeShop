package br.com.rtd.pokeshop.ui.description

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.rtd.pokeshop.databinding.ActivityDescriptionPokeCardBinding
import br.com.rtd.pokeshop.databinding.ActivityProductListBinding
import br.com.rtd.pokeshop.extesions.addImagemWithCoil
import br.com.rtd.pokeshop.model.entity.PokemonCard
import java.text.NumberFormat
import java.util.*

class DescriptionPokeCard : AppCompatActivity() {
    private val binding by lazy {
        ActivityDescriptionPokeCardBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title = "Descrição"

        updateCard()
    }

    private fun updateCard() {

        val pokeCard = getCardIntent()

        val name = binding.pokemonCardTextName
        val type = binding.pokemonCardTextTipe
        val valor = binding.pokemonCardTextValor
        val desc = binding.pokemonCardTextDesc
        val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        val valorF = format.format(pokeCard.valor)

        name.text = pokeCard.name
        type.text = pokeCard.type.toString()
        valor.text = valorF
        desc.text =pokeCard.description

        binding.pokemonCardImage.addImagemWithCoil(pokeCard.urlImagem)

    }

    private fun getCardIntent(): PokemonCard {
        return intent.extras?.get("KEY_CARD") as PokemonCard
    }


}