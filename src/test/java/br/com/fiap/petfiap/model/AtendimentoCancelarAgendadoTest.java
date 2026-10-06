package br.com.fiap.petfiap.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teste unitario do model: sem banco, sem Spring (Aula 15).
public class AtendimentoCancelarAgendadoTest {

    @Test
    public void deveCancelarQuandoAtendimentoEstaAgendado() {
        // Arrange
        Banho banho = new Banho(1, "Rex", "PEQUENO", "Ana", LocalDateTime.of(2026, 10, 1, 10, 0));

        // Act
        banho.cancelar();

        // Assert
        assertEquals("CANCELADO", banho.getStatus());
    }
}