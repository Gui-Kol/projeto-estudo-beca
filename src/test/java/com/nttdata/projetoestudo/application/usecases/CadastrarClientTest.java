package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarClientTest {
    @InjectMocks
    private CadastrarClient cadastrarClient;
    @Mock
    private RepositorioDeClient repository;

    @Test
    void cadastrarNovoClient() {
        Client entrada = new Client("Nome Teste", "asda", 1234567890);
        Client persistido = new Client(1L,"Nome Teste", "asda", 1234567890);
        when( repository.cadastrarClient(entrada)).thenReturn(persistido);
        Client resultado = cadastrarClient.cadastrar(entrada);


        assertNotNull(resultado);
        assertEquals(persistido, resultado);
        verify(repository, times(1)).cadastrarClient(entrada);
        verifyNoMoreInteractions(repository);

    }
}