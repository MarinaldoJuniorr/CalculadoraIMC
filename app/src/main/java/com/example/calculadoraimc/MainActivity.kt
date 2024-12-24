package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btncalcular = findViewById<Button>(R.id.button)

        btncalcular.setOnClickListener {


            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String= edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()


                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                println("Marinaldo acao do botao" + resultado)
            }





        }
    }
}