package com.fabricio.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fabricio.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setListernners()
    }
    private fun setListernners(){

        viewBinding.btCalcular.setOnClickListener {
            calcularIMC(altura = viewBinding.etAltura.text.toString(),peso = viewBinding.etPeso.text.toString())
        }
    }

    private fun calcularIMC(altura: String, peso: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val IMC = peso / (altura * altura)
            viewBinding.etResult.text = getString(R.string.resultado,IMC)
            viewBinding.etResult.visibility = View.VISIBLE
        }
    }

}