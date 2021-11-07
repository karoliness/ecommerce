package com.projeto.ecommerce.dominio.catalogo;

import java.util.List;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public abstract class Produto {
    private Integer id;
    private String isbn;
    private String nome;
    private List<Autor> autores;


    public Produto(Integer id, String isbn, String nome, List<Autor> autores) {
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
