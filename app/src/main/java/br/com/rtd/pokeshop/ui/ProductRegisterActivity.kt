package br.com.rtd.pokeshop.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.rtd.pokeshop.R
import br.com.rtd.pokeshop.dao.PokemonCardDao
import br.com.rtd.pokeshop.databinding.ActivityProductRegisterBinding
import br.com.rtd.pokeshop.databinding.AddImagemDialogBinding
import br.com.rtd.pokeshop.extesions.addImagemWithCoil
import br.com.rtd.pokeshop.model.entity.PokemonCard
import br.com.rtd.pokeshop.model.enums.CardTypes
import br.com.rtd.pokeshop.ui.dialog.AddImagemDialog
import java.math.BigDecimal

class ProductRegisterActivity : AppCompatActivity() {

    private var url: String? = null

    private val binding by lazy {
        ActivityProductRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrando carta"

        binding.cardImageRegister.setOnClickListener {
            AddImagemDialog(this).showDialog(url) { imagem ->
                url = imagem
                binding.cardImageRegister.addImagemWithCoil(url)
            }
        }

        var cardTypeRadio = binding.pokemonCardTypeGroupRadio.checkedRadioButtonId

        binding.pokemonCardTypeGroupRadio.setOnCheckedChangeListener { group, checkedId ->
            cardTypeRadio = checkedId
        }
        binding.cardSaveButtom.setOnClickListener {
            saveButtonConfig(cardTypeRadio)
        }

    }

    private fun saveButtonConfig(cardTypeRadio: Int) {

        val cardNameInput = binding.cardNameInput
        val cardDescInput = binding.cardDescInput
        val cardPrecInput = binding.cardPrecInput

        val cardName = cardNameInput.text.toString()
        val cardDesc = cardDescInput.text.toString()
        val presc = cardPrecInput.text.toString()

        if (cardName.isBlank() || cardDesc.isBlank() || presc.isBlank() || cardTypeRadio == -1) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

        } else {
            val cardPresc = if (presc.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(presc)
            }
            val cardType = howCardType(cardTypeRadio)
            val pokemonCard = PokemonCard(name = cardName,
                valor = cardPresc,
                description = cardDesc,
                type = cardType,
                urlImagem = url)

            salveCard(pokemonCard)
            Log.d("Pokemon", pokemonCard.toString())

            finish()
        }

    }

    private fun salveCard(pokemonCard: PokemonCard) {
        val pokemonCardDao = PokemonCardDao()
        pokemonCardDao.addCard(pokemonCard)
    }


    private fun howCardType(checkedId: Int): CardTypes {
        return when (checkedId) {
            R.id.radio_type_item ->
                CardTypes.ITEM
            R.id.radio_type_pokemon ->
                CardTypes.POKEMON
            R.id.radio_type_stadium ->
                CardTypes.STADIUM
            R.id.radio_type_supporter ->
                CardTypes.SUPPORTER
            else ->
                CardTypes.TOOL
        }
    }

    fun onRadioButtonClicked(view: android.view.View) {

    }


}