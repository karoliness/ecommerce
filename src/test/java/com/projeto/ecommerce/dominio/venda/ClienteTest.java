package com.projeto.ecommerce.dominio.venda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.projeto.ecommerce.dominio.venda.builders.ClienteBuilder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ClienteTest {
    private ClienteBuilder clienteBuilder;

    public ClienteTest(){
        clienteBuilder = new ClienteBuilder().build();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "  "})
    public void deveSerObrigatorioOnome(String nomeDoClienteParametro){
        Exception erroEncontrado = assertThrows(Exception.class, () -> new Cliente(nomeDoClienteParametro, clienteBuilder.endereco));
        assertEquals("O nome é obrigatório", erroEncontrado.getMessage());
    }
}
