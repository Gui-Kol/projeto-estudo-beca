package com.nttdata.projetoestudo.infra.controller;

import com.nttdata.projetoestudo.application.Dto.LoginDto;
import com.nttdata.projetoestudo.infra.gateway.ClientMapper;
import com.nttdata.projetoestudo.infra.persistence.ClientEntity;
import com.nttdata.projetoestudo.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    TokenService tokenService;
    @Autowired
    ClientMapper mapper;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody LoginDto dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.email(), dto.cpf());
        var auth = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken(mapper.toClient((ClientEntity) auth.getPrincipal())));
    }


}
