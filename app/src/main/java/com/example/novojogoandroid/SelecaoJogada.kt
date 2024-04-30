package com.example.novojogoandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.novojogoandroid.databinding.SelecaoJogadaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class SelecaoJogada : AppCompatActivity() {

    private val binding by lazy { SelecaoJogadaBinding.inflate(layoutInflater) }
    lateinit var drawerHeader: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbarInicio = binding.toolbarHomeSelecao
        setSupportActionBar(toolbarInicio)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerHeader = binding.drawerLayout
        navView= binding.navView

        spinnerJogada()
        setUpToolBar()

    }

    private fun setUpToolBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    }
    override fun onSupportNavigateUp(): Boolean {
        drawerHeader.openDrawer(GravityCompat.START)
        return true
    }

    fun spinnerJogada() {
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
