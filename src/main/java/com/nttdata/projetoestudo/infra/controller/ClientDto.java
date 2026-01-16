package com.nttdata.projetoestudo.infra.controller;

public record ClientDto(
        String name,
        String email,
        int cpf
) {

}
