package com.projeto.ecommerce.dominio.catalogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LivroTest {
    private Faker faker = new Faker(new Locale("pt-BR"));

    private Integer id = faker.number().numberBetween(1, 500);
    private String isbn = faker.idNumber().ssnValid();
    private String nome = faker.book().title();
    private Autor autor;
    private List<Autor> autores = new ArrayList<Autor>();
    private String resumo = faker.random().hex();
    private Integer quantidadePaginas = faker.number().numberBetween(1, 500);
    private String edicao = faker.random().toString();
    
    private LivroTest() throws Exception {
        autor = new Autor(faker.name().fullName());
    }

    private void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = { 0, -2 })
    public void deveSerObrigatorioOIdDoLivro(Integer idDoParametro) throws Exception {
        adicionarAutor(autor);

        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(idDoParametro, isbn, nome, autores, resumo, quantidadePaginas, edicao));
        assertEquals("O id do produto é um campo obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "", "  " })
    public void deveSerObrigatorioOIsbnDoLivro(String isbnParametro) throws Exception {
        adicionarAutor(autor);

        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(id, isbnParametro, nome, autores, resumo, quantidadePaginas, edicao));
        assertEquals("O isbn do produto é um campo obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "", "  " })
    public void deveSerObrigatorioOnomeDoLivro(String nomeParametro) throws Exception {
        adicionarAutor(autor);

        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(id, isbn, nomeParametro, autores, resumo, quantidadePaginas, edicao));
        assertEquals("O nome do produto é um campo obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void devePossuiPeloMenos1AutorNoLivro() throws Exception {
        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao));
        assertEquals("O produto deve possuir autor", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "", "  " })
    public void deveSerObrigatorioOResumoDoLivro(String resumoDoLivroParametro) throws Exception {
        adicionarAutor(autor);
        Exception erroEncontrado = assertThrows(Exception.class,
                () -> new Livro(id, isbn, nome, autores, resumoDoLivroParametro, quantidadePaginas, edicao));
        assertEquals("O resumo do livro é um campo obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1})
    public void deveSerObrigatorioAQuantidadeDePaginas(Integer quantidadeDePaginasParametro){
        adicionarAutor(autor);
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(id, isbn, nome, autores, resumo, quantidadeDePaginasParametro, edicao));
       
        assertEquals("A quantidade de páginas é um campo obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "", " "})
    public void deveSerObrigatorioONumeroDaEdicao(String edicaoParametro){
        adicionarAutor(autor);
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicaoParametro));
       
        assertEquals("A edição é um campo obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarONomeDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        var livro = new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao);

        assertEquals(nome, livro.getNome());
    }

    @Test
    public void deveRetornarOResumoDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        var livro = new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao);

        assertEquals(resumo, livro.getResumo());
    }

    @Test
    public void deveRetornarOsAutoresDoLivroCorretamente() throws Exception {
        adicionarAutor(autor);
        var livro = new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao);

        assertEquals(autores, livro.getAutores());
    }

    @Test
    public void deveRetornarAQuantidadeDePaginas() throws Exception{
        adicionarAutor(autor);
        var livro = new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao);

        assertEquals(quantidadePaginas, livro.getQuantidadePaginas());
    }

    @Test
    public void deveRetornarAEdicao() throws Exception{
        adicionarAutor(autor);
        var livro = new Livro(id, isbn, nome, autores, resumo, quantidadePaginas, edicao);
        
        assertEquals(edicao, livro.getEdicao());
    }
}
