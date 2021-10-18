package br.com.rtd.pokeshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rtd.pokeshop.databinding.ProductItemBinding
import br.com.rtd.pokeshop.model.entity.Product
import br.com.rtd.pokeshop.model.enums.CardTypes
import java.text.NumberFormat
import java.util.*

class ProductListActivityAdapter : RecyclerView.Adapter<ProductListActivityAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setProduct(product: Product) {
            val name = binding.pokemonCardTextName
            val type = binding.pokemonCardTextTipe
            val valor = binding.pokemonCardTextValor
            val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val valorF = format.format(product.valor)

            name.text = product.name
            type.text = product.type.toString()
            valor.text = valorF
        }
    }

    private val product = Product(
        name = "Pikachu",
        valor = "10.0".toBigDecimal(),
        description = "",
        type = CardTypes.POKEMON
    )
    private val productMutableList = mutableListOf<Product>(product)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductListActivityAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListActivityAdapter.ViewHolder, position: Int) {
        val product = productMutableList[position]
        holder.setProduct(product)
    }

    override fun getItemCount(): Int = productMutableList.size


}
