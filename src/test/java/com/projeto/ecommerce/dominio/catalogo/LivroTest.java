package com.projeto.ecommerce.dominio.catalogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.projeto.ecommerce.dominio.catalogo.Autor;
import com.projeto.ecommerce.dominio.catalogo.DetalheDoLivro;
import com.projeto.ecommerce.dominio.catalogo.Livro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LivroTest {
    private Faker faker = new Faker();
    private String isbn = faker.idNumber().ssnValid();
    private String nome = faker.book().title();
    private String resumo = faker.random().hex();
    private Double preco = faker.number().randomDouble(2, 10, 300);
    private String edicao = faker.random().toString();
    private Integer quantidadePaginas = faker.number().numberBetween(1, 500);
    private Autor autor;
    private List<Autor> autores;
    private Double desconto = 0.0;

    private LivroTest() throws Exception {
        autor = new Autor(faker.name().fullName());
        autores = new ArrayList<Autor>();
    }

    private void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "", "  " })
    public void deveSerObrigatorioOnomeDoLivro(String nome) throws Exception {
        adicionarAutor(autor);

        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(isbn, nome, preco, autores,desconto, resumo, ));
        assertEquals("O nome do produto é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "", "  " })
    public void deveSerObrigatorioOResumoDoLivro(String resumoDoLivro) throws Exception {
        adicionarAutor(autor);
        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(isbn, nome, preco, autores,desconto, resumoDoLivro, ));
        assertEquals("O resumo do livro é obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void devePossuiPeloMenos1DetalheNoLivro() throws Exception {
        adicionarAutor(autor);

        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(isbn, nome, preco, autores,desconto, resumo));
        assertEquals("O livro deve possuir detalhes", erroEncontrado.getMessage());
    }

    @Test
    public void devePossuiPeloMenos1AutorNoLivro() throws Exception {
        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(isbn, nome, preco, autores,desconto, resumo,));
        assertEquals("O autor do produto é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1 })
    public void deveTerPrecoMaiorQueZeroOLivro(Double precoDoLivro) throws Exception {
        adicionarAutor(autor);
        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(isbn, nome, precoDoLivro, autores,desconto, resumo, detalhesDoLivro));
        assertEquals("O preço do produto é obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarONomeDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        adicionarDetalhesDolivro(detalheDoLivro);
        var livro = new Livro(isbn, nome, preco, autores,desconto, resumo, detalhesDoLivro);

        assertEquals(nome, livro.getNome());
    }

    @Test
    public void deveRetornarOResumoDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        adicionarDetalhesDolivro(detalheDoLivro);
        var livro = new Livro(isbn, nome, preco, autores,desconto, resumo, detalhesDoLivro);

        assertEquals(resumo, livro.getResumo());
    }

    @Test
    public void deveRetornarOsAutoresDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        var livro = new Livro(isbn, nome, preco, autores,desconto, resumo,);

        assertEquals(autores, livro.getAutores());
    }

    @Test
    public void deveRetornarOPrecoDoLivro() throws Exception{
        adicionarAutor(autor);

        var livro = new Livro(isbn, nome, preco, autores,desconto, resumo, );

        assertEquals(preco, livro.getPreco());
    }


    @ParameterizedTest
    @ValueSource(ints = { 0, -1})
    public void deveSerObrigatorioAQuantidadeDePaginas(Integer quantidadePaginas){
        Exception erroEncontrado = assertThrows(Exception.class, () -> new DetalheDoLivro(quantidadePaginas, edicao));
       
        assertEquals("A quantidade de páginas é obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarAQuantidadeDePaginas() throws Exception{
        var detalheDoLivro = new DetalheDoLivro(quantidadeDePaginas, edicao);

        assertEquals(quantidadeDePaginas, detalheDoLivro.getQuantidadePaginas());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " "})
    public void deveSerObrigatorioONumeroDaEdicao(String edicaoParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> new DetalheDoLivro(quantidadeDePaginas, edicaoParametro));
       
        assertEquals("A edição é obrigatória", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarAEdicao() throws Exception{
        var detalheDoLivro = new DetalheDoLivro(quantidadeDePaginas, edicao);
        
        assertEquals(edicao, detalheDoLivro.getEdicao());
    }
}
