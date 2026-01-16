package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListarClientTest {
    @InjectMocks
    ListarClient listarClient;
    @Mock
    private RepositorioDeClient repository;
    @Test
    void listar(){
        List<Client> lista = List.of(new Client(1L,"Nome Teste1", "asda1", 1234567891),
                new Client(2L,"Nome Teste2", "asda2", 1234567892));

        when(repository.listarClients()).thenReturn(lista);
        List<Client> resultado = listarClient.listar();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(lista, resultado);

        verify(repository, times(1)).listarClients();
        verifyNoMoreInteractions(repository);
    }
}