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
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class ListarClientPorNomeTest {
    @InjectMocks
    ListarClientPorNome listarClient;
    @Mock
    private RepositorioDeClient repository;

    @Test
    void listar(){
        List<Client> listaResposta = List.of(new Client(1L,"Nome Teste1", "asda1", 1234567891));

        String nome = "Nome Teste1";

        when(repository.listarClientsPorNome(nome)).thenReturn(listaResposta);
        List<Client> resultado = listarClient.listar(nome);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(listaResposta, resultado);

        verify(repository, times(1)).listarClientsPorNome(nome);
        verifyNoMoreInteractions(repository);
    }
}