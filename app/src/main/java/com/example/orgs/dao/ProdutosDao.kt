package com.example.orgs.dao

import com.example.orgs.model.Produto

class ProdutosDao {

    fun addNewProduct(product: Produto) {
        products.add(product)
    }

    fun showAllProducts() : List<Produto> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Produto>()
    }
}
