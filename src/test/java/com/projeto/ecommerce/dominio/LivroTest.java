package com.projeto.ecommerce.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;


public class LivroTest {
    private Faker faker = new Faker();
    private String nome = faker.book().title();
    private String resumo = faker.random().hex();
    private Integer quantidadePaginas = faker.number().numberBetween(1, 500);
    private Autor autor;
    private List<Autor> autores;
    
    private LivroTest() throws Exception{
        autor =  new Autor(faker.name().fullName());
        autores = new ArrayList<Autor>();
    }

    private void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    public void deveSerObrigatorioOnomeDoLivro(String nome) throws Exception{
        adicionarAutor(autor);
       
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(nome, resumo, quantidadePaginas, autores));
        assertEquals("O nome do livro é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    public void deveSerObrigatorioOResumoDoLivro(String resumo) throws Exception{
        adicionarAutor(autor);
       
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(nome, resumo, quantidadePaginas, autores));
        assertEquals("O resumo do livro é obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void deveSerObrigatorioAQuantidadeDePaginasDoLivro() throws Exception{
        quantidadePaginas = 0;
        
        autores.add(autor);
       
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(nome, resumo, quantidadePaginas, autores));
        assertEquals("A quantidade de páginas é obrigatório", erroEncontrado.getMessage());
    }
    
    @Test
    public void devePossuiPeloMenos1AutorNoLivro() throws Exception{
       
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Livro(nome, resumo, quantidadePaginas, autores));
        assertEquals("O livro deve possui pelo menos 1 autor", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarONomeDoLivroCorretamente() throws Exception{ 
        adicionarAutor(autor);

        var livro = new Livro(nome, resumo, quantidadePaginas, autores);

        assertEquals(nome, livro.getNome());
    }

    @Test
    public void deveRetornarOResumoDoLivroCorretamente() throws Exception{
       adicionarAutor(autor);
       
        var livro = new Livro(nome, resumo, quantidadePaginas, autores);

        assertEquals(resumo, livro.getResumo());
    }

    @Test
    public void deveRetornarAQuantidadeDePaginasDoLivroCorretamente() throws Exception{
        adicionarAutor(autor);
       
        var livro = new Livro(nome, resumo, quantidadePaginas, autores);

        assertEquals(quantidadePaginas, livro.getQuantidadePaginas());
    }

    @Test
    public void deveRetornarOsAutoresDoLivroCorretamente() throws Exception{
        adicionarAutor(autor);
       
        var livro = new Livro(nome, resumo, quantidadePaginas, autores);
        
        assertEquals(autores, livro.getAutores());
    }
}
