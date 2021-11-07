package com.projeto.ecommerce.dominio.catalogo;

import java.util.List;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public class Livro extends Produto {
    private String resumo;
    private Integer quantidadePaginas;
    private String edicao;

    public Livro(Integer id, String isbn, String nome, 
            List<Autor> autores, String resumo, Integer quantidadePaginas,
            String edicao) throws Exception {
        super(id, isbn, nome, autores);
        new ExcecaoDeDominio()
        .quando(null == resumo || resumo.isBlank(), "O resumo do livro é obrigatório")
        .quando(quantidadePaginas <=0 , "A quantidade de páginas é obrigatório")
        .quando(null == edicao || edicao.isBlank(), "A edição é obrigatória")
        .lancar();
        this.resumo = resumo;
        this.quantidadePaginas = quantidadePaginas;
        this.edicao = edicao;
    }

    public String getResumo() {
        return this.resumo;
    }

    public Integer getQuantidadePaginas() {
        return this.quantidadePaginas;
    }

    public String getEdicao() {
        return this.edicao;
    }

}
