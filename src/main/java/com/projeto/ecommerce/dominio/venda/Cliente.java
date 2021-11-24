package com.projeto.ecommerce.dominio.venda;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public class Cliente {
    private Integer id;
    private String nome;
    private Endereco endereco;

    public Cliente(String nome, Endereco endereco) throws Exception {
        new ExcecaoDeDominio()
        .quando(null == nome || nome.isBlank(), "O nome é obrigatório")
        .quando(null == endereco, "O endereço é obrigatório")
        .lancar();
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
