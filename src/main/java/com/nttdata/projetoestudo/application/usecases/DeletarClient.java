package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;

public class DeletarClient {
    private final RepositorioDeClient repository;

    public DeletarClient(RepositorioDeClient repository) {
        this.repository = repository;
    }

    public void deletar(Long clientId) {
        repository.deletarClientById(clientId);
    }
}
