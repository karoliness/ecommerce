package com.projeto.ecommerce.dominio.catalogo;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public class Autor {
    private String nome;
     
    public Autor(String nome) throws Exception {
        new ExcecaoDeDominio().quando(null == nome ||nome.isBlank(), "O nome do autor é obrigatório").lancar();
        this.nome = nome;
    }


    public String getNome() {
        return this.nome;
    }
}
