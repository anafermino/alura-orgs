package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityListaProdutosBinding
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.showAllProducts())
    private lateinit var binding: ActivityListaProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        configRecyclerView()
        configFab()

        // Teste para lista com produtos mockados
//        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
//            Produto(name = "abobora",
//                description = "super fresca",
//                price = BigDecimal("4.30")
//            ),
//            Produto(name = "cenoura",
//                description = "orgânica",
//                price = BigDecimal("5.00")
//            )
//        ))
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.showAllProducts()) // método para o adapter atualizar nossa lista sempre que voltar pra tela da lista.
    }

    private fun configRecyclerView() {
        val recyclerView = binding.alpRvProdutos
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configFab() {
        binding.alpFabAdd.setOnClickListener {
            Intent(this, FormularioProdutoActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
