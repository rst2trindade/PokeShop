package br.com.rtd.pokeshop.extesions

import android.widget.ImageView
import br.com.rtd.pokeshop.R
import coil.load

fun ImageView.addImagemWithCoil(urlImagem: String?) {
    load(urlImagem) {
        fallback(R.drawable.ic_error)
        error(R.drawable.ic_error)
    }

}
