package cl.usm.calculadoraspring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
        calculadoraService = new CalculadoraService();
    }

    @Test
    void calcularSumaOk() {
        double res = calculadoraService.calcular("+", 1, 2);
        assertEquals(3, res);
    }

    @Test
    void calcularRestaOk() {
        double res = calculadoraService.calcular("-", 4, 1);
        assertEquals(3, res);
    }

    @Test
    void calcularMultiplicacionOk() {
        double res = calculadoraService.calcular("*", 3, 1);
        assertEquals(3, res);
    }

    @Test
    void calcularDivisionOk() {
        double res = calculadoraService.calcular("/", 3, 1);
        assertEquals(3, res);
    }

    @Test
    void calcularDivisionNok() {
        Exception ex = assertThrows(NumberFormatException.class, ()->{
            double res = calculadoraService.calcular("/", 2, 0);
        });
        assertEquals("can't divide by zero", ex.getMessage());
    }

    @Test
    void calcularOperacionNok() {
        Exception ex = assertThrows(NumberFormatException.class, ()->{
            double res = calculadoraService.calcular("fake", 2, 0);
        });
        assertEquals("Invalid operation", ex.getMessage());
    }

}