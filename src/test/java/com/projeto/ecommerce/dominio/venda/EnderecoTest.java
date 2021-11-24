package com.projeto.ecommerce.dominio.venda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;
import java.util.Optional;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EnderecoTest {
    private Faker faker = new Faker(new Locale("pt-BR"));

    private String logradouro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

    private EnderecoTest(){
        logradouro = faker.address().streetAddress();
        complemento = "Complemento";
        cidade = faker.address().cityName();
        estado = faker.address().state();
        cep = faker.address().zipCode();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioLogradouro(String logradouroParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouroParametro, complemento, cidade, estado, cep));
        assertEquals("O logradouro é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioCidade(String cidadeParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouro, complemento, cidadeParametro, estado, cep));
        assertEquals("A cidade é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioEstado(String estadoParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouro, complemento, cidade, estadoParametro, cep));
        assertEquals("O estado é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioCep(String cepParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouro, complemento, cidade, estado, cepParametro));
        assertEquals("O cep é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "1234567891", "1234-123"})
    public void devePossuirTamanhoIgualAOitoOCep(String cepParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouro, complemento, cidade, estado, cepParametro));
        assertEquals("O cep é inválido", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarOLogradouroCorretamente() throws Exception{
        var endereco = new Endereco(logradouro, complemento, cidade, estado, cep);

        assertEquals(logradouro, endereco.getLogradouro());
    }

    @Test
    public void deveRetornarOComplementoCorretamente() throws Exception{
        var endereco = new Endereco(logradouro, complemento, cidade, estado, cep);

        assertEquals(complemento, endereco.getComplemento());
    }

    @Test
    public void deveRetornarOComplementoMesmoSemPassarComoParametro() throws Exception{
        var endereco = new Endereco(logradouro, cidade, estado, cep);

        assertEquals(null, endereco.getComplemento());
    }
}
