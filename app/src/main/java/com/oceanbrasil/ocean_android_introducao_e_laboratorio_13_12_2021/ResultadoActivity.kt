package com.oceanbrasil.ocean_android_introducao_e_laboratorio_13_12_2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Obtém a informação que foi passada junto com a Intent
        val name = "NOME_DIGITADO"
        val value = intent.getCharSequenceExtra(name)

        // Acessa o elemento tvNome
        val tvNome = findViewById<TextView>(R.id.tvNome)

        // Altera o texto desse elemento
        tvNome.text = value

        // Implementação do botão voltar
        val btVoltar = findViewById<Button>(R.id.btVoltar)
        btVoltar.setOnClickListener {
            finish()
        }
    }
}
