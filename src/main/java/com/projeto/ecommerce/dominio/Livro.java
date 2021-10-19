package com.projeto.ecommerce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String nome;
    private String resumo;
    private int quantidadePaginas;
    private List<Autor> autores = new ArrayList<Autor>();


    public Livro(String nome, String resumo, int quantidadePaginas, List<Autor> autores) throws Exception {
        new ExcessaoDeDominio()
        .quando(null == nome || nome.isEmpty(), "O nome do livro é obrigatório")
        .quando(null == resumo || resumo.isEmpty(), "O resumo do livro é obrigatório")
        .quando(quantidadePaginas <= 0, "A quantidade de páginas é obrigatório")
        .quando(autores.size() <= 0, "O livro deve possui pelo menos 1 autor")
        .lancar();
        this.nome = nome;
        this.resumo = resumo;
        this.quantidadePaginas = quantidadePaginas;
        this.autores = autores;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantidadePaginas() {
        return this.quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}