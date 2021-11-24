package com.projeto.ecommerce.dominio.venda.builders;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.projeto.ecommerce.dominio.venda.Endereco;

public class ClienteBuilder {
    private Faker faker = new Faker(new Locale("pt-BR"));
    public String nome;
    public Endereco endereco;

    public ClienteBuilder(){
        this.nome = faker.name().toString();
        this.endereco = new EnderecoBuilder().build();
    }
    public ClienteBuilder build(){
        return this;
    }
}
