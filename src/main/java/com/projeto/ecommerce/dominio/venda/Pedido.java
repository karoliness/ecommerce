package com.projeto.ecommerce.dominio.venda;

import java.util.ArrayList;
import java.util.List;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public class Pedido {
    private List<ItemDoPedido> itensDoPedido = new ArrayList<ItemDoPedido>();
    private Double valorTotalDaCompra;
    private Cliente cliente;

    public Pedido(List<ItemDoPedido> itens, Cliente cliente) throws Exception {
        this.itensDoPedido = itens;
        this.cliente = cliente;
        new ExcecaoDeDominio()
        .quando(null == itens || itens.size() <= 0, "O item do pedido é obrigatório")
        .quando(null == cliente, "O cliente é obrigatório")
        .lancar();
        calcularValorTotalDaCompra();
    }

    public List<ItemDoPedido> getItensDoPedido() {
        return this.itensDoPedido;
    }

    public Double getValorTotalDaCompra() {
        return this.valorTotalDaCompra;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    private void calcularValorTotalDaCompra(){
        this.valorTotalDaCompra = this.itensDoPedido.stream()
            .mapToDouble(x -> x.getProduto().getPreco())
            .sum();
    }
}
