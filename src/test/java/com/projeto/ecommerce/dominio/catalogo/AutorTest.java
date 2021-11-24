package com.projeto.ecommerce.dominio.catalogo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AutorTest {
    private Faker faker = new Faker(new Locale("pt-BR"));

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioOnomeDoautor(String nomeAutor){
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Autor(nomeAutor));
        assertEquals("O nome do autor é obrigatório", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarOnomeDoAutorCorretamente() throws Exception{
        var nomeAutor = faker.name().fullName();

        var autor = new Autor(nomeAutor);

        assertEquals(nomeAutor, autor.getNome());
    }
}
