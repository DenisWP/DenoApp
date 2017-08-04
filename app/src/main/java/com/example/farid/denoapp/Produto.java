package com.example.farid.denoapp;

import java.io.Serializable;

/**
 * Created by Farid on 04/08/2017.
 */

public class Produto implements Serializable{
    private String codigo, descricao, valor;



    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


    public String getValor(){
        return valor;
    }
    public void setValor(String valor){
       this.valor = valor;
    }

}
