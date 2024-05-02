package com.example.novojogoandroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.novojogoandroid.databinding.ResultadoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Resultado: AppCompatActivity() {

    private val binding by lazy { ResultadoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbarResultado = binding.toolbarHomeResultado
        setSupportActionBar(toolbarResultado)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
}