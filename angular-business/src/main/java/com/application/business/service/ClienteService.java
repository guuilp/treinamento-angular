package com.application.business.service;

import com.application.business.domain.Cliente;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import rx.Observable;

public class ClienteService extends AbstractService<Cliente> {

    public Observable<Optional<List<Cliente>>> buscarTodos() {

        StringBuilder builder = new StringBuilder("FROM ");
        builder.append(Cliente.class.getSimpleName());

        TypedQuery<Cliente> query = em.createQuery(builder.toString(), Cliente.class);

        return Observable.just(Optional.of(query.getResultList()));
    }

    public void salvarCliente(Cliente cliente) {

        cliente.setDataCadastro(Calendar.getInstance().getTime());
        super.salvar(cliente);
    }

}
