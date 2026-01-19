package com.nttdata.projetoestudo.config.client;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.application.usecases.*;
import com.nttdata.projetoestudo.infra.gateway.ClientMapper;
import com.nttdata.projetoestudo.infra.gateway.RepositorioDeClientJpa;
import com.nttdata.projetoestudo.infra.persistence.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class ClientConfig {
    @Bean
    ClientMapper mapper() {
        return new ClientMapper();
    }

    @Bean
    RepositorioDeClientJpa repository(ClientRepository repository, ClientMapper mapper, PasswordEncoder passwordEncoder) {
        return new RepositorioDeClientJpa(repository, mapper, passwordEncoder);
    }

    @Bean
    CadastrarClient cadastrarClient(RepositorioDeClient repository){
        return new CadastrarClient(repository);
    }

    @Bean
    ListarClient listarClient(RepositorioDeClient repository){
        return new ListarClient(repository);
    }

    @Bean
    DeletarClient deletarClient(RepositorioDeClient repository){
        return new DeletarClient(repository);
    }

    @Bean
    ListarClientPorNome listarClientPorNome(RepositorioDeClient repository){
        return new ListarClientPorNome(repository);
    }

    @Bean
    ListarClientPorEmail listarClientPorEmail(RepositorioDeClient repository){
        return new ListarClientPorEmail(repository);
    }


}
