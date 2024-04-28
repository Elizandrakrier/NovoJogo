package com.example.novojogoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.novojogoandroid.databinding.SelecaoJogadaBinding

class SelecaoJogada : AppCompatActivity() {

    private val binding by lazy { SelecaoJogadaBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}