package com.angular.web.rest;

import com.application.business.domain.Cliente;
import com.application.business.service.ClienteService;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import rx.Observable;

@Path("/cliente")
public class ClienteRS {

    private final ClienteService service;

    public ClienteRS() {

        service = new ClienteService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response pesquisarClientes() {

        Observable<Optional<List<Cliente>>> clientesObservable = service.buscarTodos();
        Optional<List<Cliente>> clientes = clientesObservable.toBlocking().single();

        if (clientes.isPresent())
            return Response.ok(clientes.get()).build();

        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response criarCliente(Cliente novoCliente) {

        if (StringUtils.isBlank(novoCliente.getNome()) || StringUtils.isBlank(novoCliente.getCpf()))
            return Response.status(Status.BAD_REQUEST).build();

        service.salvarCliente(novoCliente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public void deletarCliente(@PathParam("id") Long idCliente) {

        service.deletar(Cliente.class, idCliente);
    }

}
