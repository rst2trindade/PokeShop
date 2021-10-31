package br.com.rtd.pokeshop.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import br.com.rtd.pokeshop.databinding.AddImagemDialogBinding
import br.com.rtd.pokeshop.extesions.addImagemWithCoil

class AddImagemDialog(private val context: Context) {

    fun showDialog(url:String? = null,
    uppLoaderImageUrl:(imagem:String)->Unit){
        AddImagemDialogBinding.inflate(LayoutInflater.from(context)).apply {
            url?.let {
                dialogImagemview.addImagemWithCoil(it)
                dialogInputText.setText(it)
            }
            diaglogButtomRefresh.setOnClickListener {
                val url = dialogInputText.text.toString()
                dialogImagemview.addImagemWithCoil(url)
            }
            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("confirmar"){_,_ ->
                    val url = dialogInputText.text.toString()
                    uppLoaderImageUrl(url)
                }
                .setNegativeButton("Cancelar"){_,_ ->}
                .show()
                }
        }

}

