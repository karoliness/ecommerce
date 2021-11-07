package com.projeto.ecommerce.dominio.venda;

public class Produto {
    private Integer id;
    private Double preco;
    private Double desconto;
    private Integer quantidadeNoEstoque; 

    public Produto(Integer id, Double preco, Double desconto, Integer quantidade) {
        this.id = id;
        this.preco = preco;
        this.desconto = desconto;
        this.quantidadeNoEstoque = quantidade;
    }

    public Double getPreco() {
        if( this.desconto > 0){
            return this.preco = this.preco - desconto;
        }
        return this.preco;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getQuantidade() {
        return this.quantidadeNoEstoque;
    }
    
}

