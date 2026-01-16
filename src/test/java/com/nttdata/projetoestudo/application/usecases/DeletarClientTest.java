package com.nttdata.projetoestudo.application.usecases;

import com.nttdata.projetoestudo.application.repository.RepositorioDeClient;
import com.nttdata.projetoestudo.domain.entity.client.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeletarClientTest {
    @InjectMocks
    DeletarClient deletarClient;
    @Mock
    private RepositorioDeClient repository;

    @Test
    void deveDeletarClientExistente() {
        Long id = 1L;

        doNothing().when(repository).deletarClientById(id);

        deletarClient.deletar(id);

        verify(repository, times(1)).deletarClientById(id);
        verifyNoMoreInteractions(repository);
    }

}