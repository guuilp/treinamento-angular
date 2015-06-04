package com.application.business.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

}
