package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityFormularioProdutoBinding
import com.example.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val nome = binding.nome.text.toString()
//        Log.i("FormularioProdutoActivity", "onCreate: $nome")

        binding.btnSaveData.setOnClickListener {
            val nome = binding.nome.text.toString()
            val descricao = binding.descricao.text.toString()
            val valorEmTexto = binding.valor.text.toString()
            val valor = if(valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto(
                name = nome,
                description = descricao,
                price = valor
            )
            Log.i("FormularioProdutoActivity", "onCreate: $produtoNovo")
            val dao = ProdutosDao()
            dao.addNewProduct(produtoNovo)
            Log.i("FormularioProdutoActivity", "onCreate: ${dao.showAllProducts()}")
            finish()
        }
    }
}
