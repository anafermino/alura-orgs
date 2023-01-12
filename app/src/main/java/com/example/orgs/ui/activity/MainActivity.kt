package com.example.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produto
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_Produtos)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(name = "abobora",
                description = "super fresca",
                price = BigDecimal("4,30")
            ),
            Produto(name = "cenoura",
                description = "orgânica",
                price = BigDecimal("5,00")
            )
        ))
    }

}