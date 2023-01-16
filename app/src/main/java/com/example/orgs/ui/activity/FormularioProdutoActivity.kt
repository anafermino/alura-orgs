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

        configSaveBtn()
    }

    private fun configSaveBtn() {
        val dao = ProdutosDao()
        binding.afpBtnSaveData.setOnClickListener {
            val produtoNovo = createNewProduct()
            dao.addNewProduct(produtoNovo)
            finish()
        }
    }

    private fun createNewProduct(): Produto {
        val nome = binding.afpNome.text.toString()
        val descricao = binding.afpDescricao.text.toString()
        val valorEmTexto = binding.afpValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            name = nome,
            description = descricao,
            price = valor
        )
    }
}
