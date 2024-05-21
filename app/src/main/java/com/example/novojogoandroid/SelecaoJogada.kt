package com.example.novojogoandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
    lateinit var btnNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbarInicio = binding.toolbarHomeSelecao
        setSupportActionBar(toolbarInicio)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgBack = binding.imgBack
        imgBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        drawerHeader = binding.drawerLayout
        navView = binding.navView
        btnNavigationView = binding.btnNavMenu

        btnNavigationView.setBackgroundColor(android.graphics.Color.TRANSPARENT)

        spinnerJogada()
        setUpToolBar()
        drawerSelecao()
        btnNavView()
    }

    private fun setUpToolBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }
    override fun onSupportNavigateUp(): Boolean {
        drawerHeader.openDrawer(GravityCompat.START)
        return true
    }

    private fun btnNavView(){
        btnNavigationView.setOnItemSelectedListener{menuItem ->
            when(menuItem.itemId){
                R.id.btn_jogador1 -> {
                    val intentBtnJogador = Intent(this, MainActivity::class.java)
                    startActivity(intentBtnJogador)
                    true
                }
                R.id.btn_resultado -> {
                    val intentBtnResultado = Intent(this, Resultado::class.java)
                    startActivity(intentBtnResultado)
                    true
                }else -> false
            }
        }
    }
    private fun drawerSelecao(){
        navView.setNavigationItemSelectedListener{menuItem ->
            when(menuItem.itemId){
                R.id.drawer_jogador -> {
                    val intentJogador = Intent(this, SelecaoJogada::class.java)
                    startActivity(intentJogador)
                    true
                }
                R.id.drawer_resultado -> {
                    val intenetResultado = Intent(this, Resultado::class.java)
                    startActivity(intenetResultado)
                    true
                }
                else -> false
            }
        }
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
//                Toast.makeText(this@SelecaoJogada, "Você selecionou $selectedItem",
//                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}
