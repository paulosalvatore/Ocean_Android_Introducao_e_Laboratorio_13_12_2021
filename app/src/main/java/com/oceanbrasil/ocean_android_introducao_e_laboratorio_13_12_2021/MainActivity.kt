package com.oceanbrasil.ocean_android_introducao_e_laboratorio_13_12_2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Acessar o elemento que está no layout XML
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btAbrirTela = findViewById<Button>(R.id.btAbrirTela)

        // Declaramos um ouvinte para eventos de clique no btEnviar
        // Assim que um clique no btEnviar ocorrer, o código dentro
        // das chaves { } será executado
        btEnviar.setOnClickListener {
            // Pegamos o que foi digitado no EditText
            val nome = etNome.text

            // Caso o nome esteja em branco, entra no if
            if (nome.isBlank()) {
                // Exibe uma mensagem de erro no EditText
                etNome.error = getString(R.string.type_valid_name)
            } else {
                // Alteramos o texto do tvResultado para o valor que está armazenado na
                // variável 'nome'
                tvResultado.text = nome

                Toast.makeText(this, R.string.updated_successfully, Toast.LENGTH_LONG).show()
            }
        }

        // Detectar clique no botão btAbrirTela
        btAbrirTela.setOnClickListener {
            // Criamos uma intenção de abrir a tela ResultadoActivity
            val abrirTelaIntent = Intent(this, ResultadoActivity::class.java)

            // Adicionamos uma informação à Intent que abre a nova tela
            val name = "NOME_DIGITADO"
            val value = etNome.text

            abrirTelaIntent.putExtra(name, value)

            // Registramos a intenção no Android
            startActivity(abrirTelaIntent)
        }
    }
}
