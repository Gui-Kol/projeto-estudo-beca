package com.nttdata.projetoestudo.infra.kafkaservice;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogClientCadastro {
    private final RepositorioDeClient repository;

    public LogClientCadastro(RepositorioDeClient repository) {
        this.repository = repository;
    }


    @KafkaListener(topics = "client-cadastrado", groupId = "client-group")
    public void logClientCadastro(String clientEmail) {
        Client clientInfo = repository.listarClientsPorEmail(clientEmail);

        System.out.println("""
                --------------------------------------------
                Client cadastrado:
                
                """ + clientInfo.toString() + """
                
                --------------------------------------------""");
    }

}
