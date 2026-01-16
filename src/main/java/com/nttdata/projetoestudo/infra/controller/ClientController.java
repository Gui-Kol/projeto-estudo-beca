package com.nttdata.projetoestudo.infra.controller;


import com.nttdata.projetoestudo.application.usecases.CadastrarClient;
import com.nttdata.projetoestudo.application.usecases.DeletarClient;
import com.nttdata.projetoestudo.application.usecases.ListarClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import com.nttdata.projetoestudo.infra.gateway.RepositorioDeClientJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final CadastrarClient cadastrarClient;
    private final ListarClient listar;
    private final DeletarClient deletarClient;

    public ClientController(CadastrarClient cadastrarClient, ListarClient listar, DeletarClient deletarClient) {
        this.cadastrarClient = cadastrarClient;
        this.listar = listar;
        this.deletarClient = deletarClient;
    }

    @PostMapping
    public ResponseEntity cadastrarClient(@RequestBody ClientDto dto, UriComponentsBuilder uriBuilder) {
        var client = cadastrarClient.cadastrar(new Client(dto.name(),dto.email(),dto.cpf()));
        //Conferir
        var uri = uriBuilder.build(client);
        return ResponseEntity
                .created(uri)
                .body(new ClientDto(client.getName(),client.getEmail(),client.getCpf()));
    }

    @GetMapping
    public ResponseEntity listarClients() {
        var clients = listar.listar();
        return ResponseEntity.ok(clients);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletarClient(@PathVariable Long id) {
        deletarClient.deletar(id);
        return ResponseEntity.ok("Client deletado com sucesso");
    }


}
