package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;

import java.util.List;

public class ListarClientPorNome {
    private final RepositorioDeClient repository;
    public ListarClientPorNome(RepositorioDeClient repository) {
        this.repository = repository;
    }

    public List<Client> listar(String nome){
        return repository.listarClientsPorNome(nome);
    }
}
