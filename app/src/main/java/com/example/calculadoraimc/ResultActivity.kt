package com.example.calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        var result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)


        tvResult.text = result.toString()

        val (classificacao, color)  = when {
            result <= 18.5f -> "ABAIXO DO PESO" to R.color.Red
            result in 18.5f .. 24.9f ->"NORMAL" to R.color.Green
            result in 25f ..29.9f ->"SOBREPESO" to R.color.Yellow
            result in 30f ..  39.9f -> "OBESIDADE" to R.color.Orange
            else -> "OBESIDADE GRAVE" to R.color.Red
        }

        tvClassificacao.text = classificacao.toString()
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))

    }
}