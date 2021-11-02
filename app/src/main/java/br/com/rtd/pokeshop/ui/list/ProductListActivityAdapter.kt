package br.com.rtd.pokeshop.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rtd.pokeshop.databinding.ProductItemBinding
import br.com.rtd.pokeshop.extesions.addImagemWithCoil
import br.com.rtd.pokeshop.model.entity.PokemonCard
import java.text.NumberFormat
import java.util.*

class ProductListActivityAdapter(
    cardList: List<PokemonCard>,
    private val onClick: (PokemonCard) -> Unit,
) :
    RecyclerView.Adapter<ProductListActivityAdapter.ViewHolder>() {


    private val cardMutableList = cardList.toMutableList()

   inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setProduct(pokemonCard: PokemonCard) {

            val name = binding.pokemonCardTextName
            val type = binding.pokemonCardTextTipe
            val valor = binding.pokemonCardTextValor
            val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val valorF = format.format(pokemonCard.valor)

            name.text = pokemonCard.name
            type.text = pokemonCard.type.toString()
            valor.text = valorF
            binding.pokemonCardImage.addImagemWithCoil(pokemonCard.urlImagem)
            binding.root.setOnClickListener {
                onClick(pokemonCard)
            }

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = cardMutableList[position]
        holder.setProduct(product)
    }

    override fun getItemCount(): Int = cardMutableList.size

    fun updateAdapter(cards: List<PokemonCard>) {
        this.cardMutableList.clear()
        this.cardMutableList.addAll(cards)
        notifyDataSetChanged()
    }

}

