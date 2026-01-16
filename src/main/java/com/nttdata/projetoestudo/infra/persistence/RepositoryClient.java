package com.nttdata.projetoestudo.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClient extends JpaRepository<ClientEntity, Long> {
}
