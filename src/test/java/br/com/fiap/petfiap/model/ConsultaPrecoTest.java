package br.com.fiap.petfiap.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Teste unitario do model: sem banco, sem Spring (Aula 15).
public class ConsultaPrecoTest {

    @Test
    public void deveCustar150ReaisQuandoConsultaIndependenteDoPorte() {
        // Arrange
        LocalDateTime data = LocalDateTime.of(2026, 10, 1, 14, 0);
        ConsultaVeterinaria pequeno = new ConsultaVeterinaria(1, "Rex", "PEQUENO", "Ana", data);
        ConsultaVeterinaria medio = new ConsultaVeterinaria(2, "Mimi", "MEDIO", "Bruno", data);
        ConsultaVeterinaria grande = new ConsultaVeterinaria(3, "Thor", "GRANDE", "Carla", data);

        // Act + Assert: o preco e fixo, o porte nao muda o valor
        assertEquals(150.0, pequeno.calcularPreco(), 0.001);
        assertEquals(150.0, medio.calcularPreco(), 0.001);
        assertEquals(150.0, grande.calcularPreco(), 0.001);
    }
}