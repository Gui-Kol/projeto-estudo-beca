package com.nttdata.projetoestudo.infra.controller;


import com.nttdata.projetoestudo.application.Dto.ClientDto;
import com.nttdata.projetoestudo.application.usecases.CadastrarClient;
import com.nttdata.projetoestudo.application.usecases.DeletarClient;
import com.nttdata.projetoestudo.application.usecases.ListarClient;
import com.nttdata.projetoestudo.application.usecases.ListarClientPorNome;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final CadastrarClient cadastrarClient;
    private final ListarClient listar;
    private final DeletarClient deletarClient;
    private final ListarClientPorNome listarClientPorNome;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ClientController(CadastrarClient cadastrarClient, ListarClient listar, DeletarClient deletarClient, ListarClientPorNome listarClientPorNome, KafkaTemplate<String, String> kafkaTemplate) {
        this.cadastrarClient = cadastrarClient;
        this.listar = listar;
        this.deletarClient = deletarClient;
        this.listarClientPorNome = listarClientPorNome;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity cadastrarClient(@RequestBody ClientDto dto, UriComponentsBuilder uriBuilder) {
        Client client = cadastrarClient.cadastrar(new Client(dto.name(), dto.email(), dto.cpf()));
        var uri = uriBuilder.build(client);
        kafkaTemplate.send("client-cadastrado", client.getEmail());
        return ResponseEntity
                .created(uri)
                .body(new ClientDto(client.getName(), client.getEmail(), client.getCpf()));

    }

    @GetMapping
    public ResponseEntity listarClients() {
        var clients = listar.listar();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{name}")
    public ResponseEntity listarClients(@PathVariable String name) {
        var clients = listarClientPorNome.listar(name);
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarClient(@PathVariable Long id) {
        deletarClient.deletar(id);
        return ResponseEntity.ok("Client deletado com sucesso");
    }


}
