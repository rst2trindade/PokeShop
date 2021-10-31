package br.com.rtd.pokeshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.rtd.pokeshop.databinding.ActivityProductListBinding
import br.com.rtd.pokeshop.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            goProductList()
        }, 2000)
    }

    private fun goProductList() {
        val intent = Intent(this, ProductListActivity::class.java)
        startActivity(intent)
        finish()
    }
}