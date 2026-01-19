package com.nttdata.projetoestudo.infra.gateway;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import com.nttdata.projetoestudo.infra.persistence.ClientEntity;
import com.nttdata.projetoestudo.infra.persistence.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class RepositorioDeClientJpa implements RepositorioDeClient {
    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public RepositorioDeClientJpa(ClientRepository repository, ClientMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Client cadastrarClient(Client client) {
        ClientEntity entity = mapper.toClientEntity(client);
        entity.setCpf(passwordEncoder.encode(entity.getCpf()));
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
    public Client listarClientsPorEmail(String clientEmail) {
        return mapper.toClient(repository.findByEmailIgnoreCase(clientEmail));
    }


}
