package com.projeto.ecommerce.dominio.venda;

public class Cliente {
    private Integer id;
    private String nome;
    private Endereco endereco;

    public Cliente(Integer id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

}
