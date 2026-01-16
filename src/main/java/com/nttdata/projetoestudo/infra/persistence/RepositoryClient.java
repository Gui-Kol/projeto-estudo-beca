package com.nttdata.projetoestudo.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryClient extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findByNameIgnoreCase(String nome);
}
