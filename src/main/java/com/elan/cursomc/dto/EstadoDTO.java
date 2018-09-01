package com.elan.cursomc.dto;

import com.elan.cursomc.domain.Estado;

import java.io.Serializable;

public class EstadoDTO implements  Serializable {
    private Integer id;
    private String nome;

    public EstadoDTO(){
    }

    public EstadoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoDTO(Estado obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}