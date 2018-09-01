package br.com.daniell.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat

import android.widget.Toast
import br.com.daniell.primeiroprojeto.extensions.format
import br.com.daniell.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        calcularIMC(peso.toDouble(), altura.toDouble())

        Toast.makeText(this, peso, Toast.LENGTH_SHORT).show()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)

        tvIMC.text = (imc.format(0))

        if (imc < 17) {
            tvDescricao.text = getString(R.string.label_magreza)
            setImagem(R.drawable.magreza)

        } else if (imc < 18.5) {
            tvDescricao.text = getString(R.string.label_abaixo)
            setImagem(R.drawable.abaixo)

        } else if (imc < 24.9) {
            tvDescricao.text = getString(R.string.label_ideal)
            setImagem(R.drawable.ideal)
        } else if (imc < 29.9) {
            tvDescricao.text = getString(R.string.label_sobrepeso)
            setImagem(R.drawable.sobre)
        } else if (imc < 34.9) {
            tvDescricao.text = getString(R.string.label_obesidade1)
            setImagem(R.drawable.obesidade)
        } else if (imc < 39.9) {
            tvDescricao.text = getString(R.string.label_obesidade2)
            setImagem(R.drawable.obesidade)
        } else {
            tvDescricao.text = getString(R.string.label_obesidade3)
            setImagem(R.drawable.obesidade)
        }

        /*
        when (imc) {
            in 0..17 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.magreza)
            }
            in 17.1..18.5 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.abaixo)
            }
            in 18.6..24.9 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.ideal)
            }
            in 25.0..29.9 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.sobre)
            }
            in 30.0..34.9 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.obesidade)
            }
            in 35.0..39.9 -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.obesidade)
            } else -> {
                tvIMC.setText(imc.toString())
                setImagem(R.drawable.obesidade)

        }

        }*/
    }


    fun setImagem(resourceId: Int) {
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}
