package com.projeto.ecommerce.dominio;

import java.util.ArrayList;
import java.util.List;

public class ExcecaoDeDominio {
    public List<String> mensagensDeErros;
    
    public ExcecaoDeDominio(){
        this.mensagensDeErros = new ArrayList<String>();
    }

    public ExcecaoDeDominio quando(Boolean condicao, String mensagemDeErro){
        if(condicao){
            this.mensagensDeErros.add(mensagemDeErro);
        }
        return this;
    }

    public void lancar() throws Exception{
        if(this.mensagensDeErros.size() > 0){
            throw new Exception(this.mensagensDeErros.get(0));
        }
    }
}
