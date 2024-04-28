package com.example.novojogoandroid

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.novojogoandroid.databinding.SelecaoJogadaBinding

class SelecaoJogada : AppCompatActivity() {

    private val binding by lazy { SelecaoJogadaBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val spinner = binding.spinnerSelecao
        val listIntem = listOf("Pedra", "Tesoura", "Papel")

        val arrayAdapter = ArrayAdapter(
            this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, listIntem)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@SelecaoJogada, "Você selecionou $selectedItem",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

    }
}