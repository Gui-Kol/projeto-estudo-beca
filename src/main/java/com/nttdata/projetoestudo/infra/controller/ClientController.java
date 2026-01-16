package com.nttdata.projetoestudo.infra.controller;


import com.nttdata.projetoestudo.domain.entity.client.Client;
import com.nttdata.projetoestudo.infra.gateway.RepositorioDeClientJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    RepositorioDeClientJpa repository;

    @PostMapping
    public ResponseEntity cadastrarClient(@RequestBody ClientDto dto, UriComponentsBuilder uriBuilder) {
        var client = new Client(dto.name(),dto.email(),dto.cpf());
        var uri = uriBuilder
                .path("/client/{id}")
                .buildAndExpand(client.getId()).toUri();
        repository.cadastrarClient(client);
        return ResponseEntity
                .created(uri)
                .body(new ClientDto(client.getName(),
                client.getEmail(),
                client.getCpf()));
    }

    @GetMapping
    public ResponseEntity listarClients() {
        var clients = repository.listarClients();
        return ResponseEntity.ok(clients);
    }

}
