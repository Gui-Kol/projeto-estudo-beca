package com.nttdata.projetoestudo.infra.gateway;

import com.nttdata.projetoestudo.domain.entity.client.Client;
import com.nttdata.projetoestudo.infra.persistence.ClientEntity;

public class ClientMapper {

    public Client toClient(ClientEntity entity){
        return new Client(entity.getId(),entity.getName(),entity.getEmail(),entity.getCpf());
    }

    public ClientEntity toClientEntity(Client client){
        return new ClientEntity(client.getId(),client.getName(),client.getEmail(),client.getCpf());
    }

}
