package com.nttdata.projetoestudo.config;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.application.usecases.CadastrarClient;
import com.nttdata.projetoestudo.application.usecases.DeletarClient;
import com.nttdata.projetoestudo.application.usecases.ListarClient;
import com.nttdata.projetoestudo.application.usecases.ListarClientPorNome;
import com.nttdata.projetoestudo.infra.gateway.ClientMapper;
import com.nttdata.projetoestudo.infra.gateway.RepositorioDeClientJpa;
import com.nttdata.projetoestudo.infra.persistence.RepositoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ClientConfig {
    @Bean
    ClientMapper mapper() {
        return new ClientMapper();
    }

    @Bean
    RepositorioDeClientJpa repository(RepositoryClient repository, ClientMapper mapper) {
        return new RepositorioDeClientJpa(repository, mapper);
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


}
