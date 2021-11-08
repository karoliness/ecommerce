package com.projeto.ecommerce.dominio.catalogo;

import java.util.List;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public abstract class Produto {
    private Integer id;
    private String isbn;
    private String nome;
    private List<Autor> autores;


    public Produto(Integer id, String isbn, String nome, List<Autor> autores) throws Exception {
        new ExcecaoDeDominio()
        .quando(null == id || 0 >= id, "O id do produto é um campo obrigatório")
        .quando(null == isbn || isbn.isBlank(), "O isbn do produto é um campo obrigatório")
        .quando(null == nome || nome.isBlank(), "O nome do produto é um campo obrigatório")
        .quando(0 >= autores.size(), "O produto deve possuir autor")
        .lancar();
        this.id = id;
        this.isbn = isbn;
        this.nome = nome;
        this.autores = autores;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

    public Integer getId() {
        return this.id;
    }

}
