package com.projeto.ecommerce.dominio.venda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.projeto.ecommerce.dominio.venda.builders.EnderecoBuilder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EnderecoTest {

    private Endereco enderecoBuilder;

    private EnderecoTest(){
        enderecoBuilder = new EnderecoBuilder().build();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioLogradouro(String logradouroParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(logradouroParametro, enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), enderecoBuilder.getCep()));
        assertEquals("O logradouro é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioCidade(String cidadeParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), cidadeParametro, enderecoBuilder.getEstado(), enderecoBuilder.getCep()));
        assertEquals("A cidade é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioEstado(String estadoParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), estadoParametro, enderecoBuilder.getCep()));
        assertEquals("O estado é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioCep(String cepParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), cepParametro));
        assertEquals("O cep é obrigatório", erroEncontrado.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "1234567891", "1234-123"})
    public void devePossuirTamanhoIgualAOitoOCep(String cepParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> 
        new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), cepParametro));
        assertEquals("O cep é inválido", erroEncontrado.getMessage());
    }

    @Test
    public void deveRetornarOLogradouroCorretamente() throws Exception{
        var endereco = new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), enderecoBuilder.getCep());

        assertEquals(enderecoBuilder.getLogradouro(), endereco.getLogradouro());
    }

    @Test
    public void deveRetornarOComplementoCorretamente() throws Exception{
        var endereco = new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getComplemento(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), enderecoBuilder.getCep());

        assertEquals(enderecoBuilder.getComplemento(), endereco.getComplemento());
    }

    @Test
    public void deveRetornarOComplementoMesmoSemPassarComoParametro() throws Exception{
        var endereco = new Endereco(enderecoBuilder.getLogradouro(), enderecoBuilder.getCidade(), enderecoBuilder.getEstado(), enderecoBuilder.getCep());

        assertEquals(null, endereco.getComplemento());
    }
}
