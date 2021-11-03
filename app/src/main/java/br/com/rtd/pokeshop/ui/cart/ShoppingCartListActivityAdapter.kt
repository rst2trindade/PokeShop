package br.com.rtd.pokeshop.ui.cart

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rtd.pokeshop.databinding.ShoppingCartItemBinding
import br.com.rtd.pokeshop.extesions.addImagemWithCoil
import br.com.rtd.pokeshop.model.entity.CartItem
import br.com.rtd.pokeshop.model.entity.PokemonCard
import java.text.NumberFormat
import java.util.*
import kotlin.reflect.KFunction1

class ShoppingCartListActivityAdapter(
    private val cardsInCartList: List<CartItem>,
    private val addClick: (PokemonCard) -> Unit,
    private val removeClick: (PokemonCard) -> Boolean,
) :
    RecyclerView.Adapter<ShoppingCartListActivityAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ShoppingCartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setCartItem(cartItem: CartItem) {
            val name = binding.cardNameCart
            val itemQuantity = binding.itemCartQuantity
            val totalPrice = binding.itemCartTotalPrice
            val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val valorF = format.format(cartItem.getTotal())

            binding.cardImagemCart.addImagemWithCoil(cartItem.pokemonCard.urlImagem)

            name.text = cartItem.pokemonCard.name
            itemQuantity.text = cartItem.cardsCount.toString()
            totalPrice.text = "Total: $valorF"


            binding.itemCartAdd.setOnClickListener {
                addClick(cartItem.pokemonCard)
                notifyItemChanged(absoluteAdapterPosition)
            }
            binding.itemCartMinus.setOnClickListener {
                if(removeClick(cartItem.pokemonCard)) {
                    notifyItemRemoved(absoluteAdapterPosition)
                }else notifyItemChanged(absoluteAdapterPosition)

            }
                Log.d("LISTA DE CARTAS",cardsInCartList.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ShoppingCartItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cardsInCartList[position]
        holder.setCartItem(cartItem)
    }

    override fun getItemCount(): Int = cardsInCartList.size


}
