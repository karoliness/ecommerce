package com.projeto.ecommerce.dominio.venda;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemDoPedido> itensDoPedido = new ArrayList<ItemDoPedido>();
    private Double valorTotalDaCompra;


    public Pedido(List<ItemDoPedido> itens) {
        this.itensDoPedido = itens;
    }

    public Double calcularValorTotalDaCompra(){
        this.valorTotalDaCompra = this.itensDoPedido.stream()
            .mapToDouble(x -> x.getProduto().getPreco())
            .sum();
        return this.valorTotalDaCompra;
    }
}
