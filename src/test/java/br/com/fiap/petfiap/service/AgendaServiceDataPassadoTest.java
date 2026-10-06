package br.com.fiap.petfiap.service;

import br.com.fiap.petfiap.model.Banho;
import br.com.fiap.petfiap.repository.AtendimentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;

// Teste unitario da agenda: NAO sobe o Spring e NAO conecta no Oracle (Aula 15).
@ExtendWith(MockitoExtension.class)
public class AgendaServiceDataPassadoTest {

    @Mock
    private AtendimentoRepository repository;

    @InjectMocks
    private AgendaService service;

    @Test
    public void deveRecusarAgendamentoQuandoDataForNoPassado() {
        // Arrange: banho marcado para ontem
        Banho banho = new Banho(1, "Rex", "PEQUENO", "Ana", LocalDateTime.now().minusDays(1));

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> service.agendar(banho));

        // O banco nem e consultado
        verifyNoInteractions(repository);
    }
}