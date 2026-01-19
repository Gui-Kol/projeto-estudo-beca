package com.nttdata.projetoestudo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Client usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API NTTData")
                    .withSubject(usuario.getCpf())
                    .sign(algoritmo);

        }catch (Exception e){
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }
}
