package com.projeto.ecommerce.dominio.venda;


public class ItemDoPedido {
    private Integer id;
    private Produto produto;
    private Integer quantidadeDeCompra;

    public ItemDoPedido(Integer id, Produto produto, Integer quantidadeDeCompra) {
        this.id = id;
        this.produto = produto;
        this.quantidadeDeCompra = quantidadeDeCompra;
    }

    public Integer getId() {
        return this.id;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public Integer getQuantidadeDeCompra() {
        return this.quantidadeDeCompra;
    }

}
