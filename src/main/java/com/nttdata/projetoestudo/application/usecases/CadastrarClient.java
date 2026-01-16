package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;

public class CadastrarClient {
    private final RepositorioDeClient repository;

    public CadastrarClient(RepositorioDeClient repository) {
        this.repository = repository;
    }

    public Client cadastrar(Client client) {
        return repository.cadastrarClient(client);

    }

}
