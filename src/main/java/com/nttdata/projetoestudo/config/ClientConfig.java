package com.nttdata.projetoestudo.config;

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
    RepositorioDeClientJpa repository(RepositoryClient repositoryClient, ClientMapper mapper) {
        return new RepositorioDeClientJpa(repositoryClient, mapper);
    }


}
