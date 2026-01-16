package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;

import java.util.List;

public class ListarClient {
    private final RepositorioDeClient repository;

    public ListarClient(RepositorioDeClient repository) {
        this.repository = repository;
    }

    public List<Client> listar(){
        return repository.listarClients();
    }

}
