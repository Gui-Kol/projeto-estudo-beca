package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;

public class ListarClientPorEmail {
    private final RepositorioDeClient repository;

    public ListarClientPorEmail(RepositorioDeClient repository) {
        this.repository = repository;
    }

    public Client listar(String email) {
        return repository.listarClientsPorEmail(email);
    }
}
