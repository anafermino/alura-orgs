package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.databinding.ActivityMainBinding
import com.example.orgs.model.Produto
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = binding.rvProdutos
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(name = "abobora",
                description = "super fresca",
                price = BigDecimal("4.30")
            ),
            Produto(name = "cenoura",
                description = "orgânica",
                price = BigDecimal("5.00")
            )
        ))
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
