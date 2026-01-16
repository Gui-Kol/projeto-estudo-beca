package com.nttdata.projetoestudo.application.repository;

import com.nttdata.projetoestudo.domain.entity.client.Client;

import java.util.List;

public interface RepositorioDeClient {
    Client cadastrarClient(Client client);

    List<Client> listarClients();

    void deletarClientById(Long clientId);

    List<Client> listarClientsPorNome(String name);

    List<Client> listarClientsPorEmail(String clientEmail);
}
