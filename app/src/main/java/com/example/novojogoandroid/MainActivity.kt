package com.example.novojogoandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.novojogoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbarInicio = binding.toolbarHome
        setSupportActionBar(toolbarInicio)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val selecaoSegundaTela = Intent (this, SelecaoJogada::class.java)

        binding.btnIniciar.setOnClickListener {
            startActivity(selecaoSegundaTela)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return true
    }
}
