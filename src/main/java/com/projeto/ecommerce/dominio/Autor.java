package com.projeto.ecommerce.dominio;

public class Autor {
    private String nome;
     
    public Autor(String nome) throws Exception {
        new ExcessaoDeDominio().quando(null == nome ||nome.isEmpty(), "O nome do autor é obrigatório").lancar();
        this.nome = nome;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
