package com.nttdata.projetoestudo.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    List<ClientEntity> findByNameIgnoreCase(String nome);

    ClientEntity findByEmailIgnoreCase(String email);

    UserDetails findByEmail(String email);
}
