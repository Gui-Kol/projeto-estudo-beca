package com.nttdata.projetoestudo.infra.persistence;

import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface RepositoryClient extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findByNameIgnoreCase(String nome);

    List<ClientEntity> findByEmailIgnoreCase(String clientEmail);
}
