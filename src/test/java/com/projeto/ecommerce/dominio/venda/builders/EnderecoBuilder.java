package com.projeto.ecommerce.dominio.venda.builders;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.projeto.ecommerce.dominio.venda.Endereco;

public class EnderecoBuilder {
    private Faker faker = new Faker(new Locale("pt-BR"));
    public String logradouro;
    public String complemento;
    public String cidade;
    public String estado;
    public String cep; 


    public EnderecoBuilder() {
        this.logradouro = faker.address().streetAddress();
        this.complemento = "Complemento";
        this.cidade = faker.address().cityName();
        this.estado =  faker.address().state();
        this.cep = faker.address().zipCode();
    }

    public Endereco build(){
        return new Endereco(logradouro, cidade, estado, cep);
    }


}
