package com.projeto.ecommerce.dominio.venda;

import com.projeto.ecommerce.dominio.ExcecaoDeDominio;

public class Endereco {
    private String logradouro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;


    public Endereco(String logradouro, String complemento , String cidade, String estado, String cep) throws Exception {
        new ExcecaoDeDominio()
        .quando(null == logradouro || logradouro.isBlank(), "O logradouro é obrigatório")
        .quando(null == cidade || cidade.isBlank(), "A cidade é obrigatório")
        .quando(null == estado || estado.isBlank(), "O estado é obrigatório")
        .quando(null == cep || cep.isBlank(), "O cep é obrigatório")
        .quando(null!= cep && 8 != cep.replaceAll("-", "").length(), "O cep é inválido" )
        .lancar();
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }


    public Endereco(String logradouro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCep() {
        return this.cep;
    }

}
