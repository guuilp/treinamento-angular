package com.application.business.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Cliente extends Entidade {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String email;
    private Date dataCadastro;

    public Cliente() {

        super();
    }

    public Cliente(String nome, String cpf, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {

        return nome;
    }

    public String getCpf() {

        return cpf;
    }

    public String getEmail() {

        return email;
    }

    public Date getDataCadastro() {

        return dataCadastro;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setDataCadastro(Date dataCadastro) {

        this.dataCadastro = dataCadastro;
    }

}
