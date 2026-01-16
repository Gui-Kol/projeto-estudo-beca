package com.nttdata.projetoestudo.infra.gateway;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import com.nttdata.projetoestudo.infra.persistence.RepositoryClient;

import java.util.List;

public class RepositorioDeClientJpa implements RepositorioDeClient {
    private final RepositoryClient repository;
    private final ClientMapper mapper;

    public RepositorioDeClientJpa(RepositoryClient repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Client cadastrarClient(Client client) {
        var entity = mapper.toClientEntity(client);
        repository.save(entity);
        return mapper.toClient(entity);
    }

    @Override
    public List<Client> listarClients() {
        return repository.findAll()
                .stream()
                .map(mapper::toClient)
                .toList();
    }

    @Override
    public void deletarClientById(Long clientId) {
        repository.deleteById(clientId);
    }

    @Override
    public List<Client> listarClientsPorNome(String nome) {
        return repository.findByNameIgnoreCase(nome)
                .stream()
                .map(mapper::toClient)
                .toList();
    }

    @Override
    public List<Client> listarClientsPorEmail(String clientEmail) {
        return repository.findByEmailIgnoreCase(clientEmail)
                .stream()
                .map(mapper::toClient)
                .toList();
    }


}
