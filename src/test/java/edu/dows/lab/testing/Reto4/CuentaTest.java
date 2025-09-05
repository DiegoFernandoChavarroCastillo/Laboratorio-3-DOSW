package edu.dows.lab.testing.Reto4;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testDepositoYRetiro() {
        Cuenta cuenta = new Cuenta("12345", "Valeria", "01");
        cuenta.depositar(500);
        assertEquals(500, cuenta.getSaldo());

        boolean exito = cuenta.retirar(200);
        assertTrue(exito);
        assertEquals(300, cuenta.getSaldo());
    }

    @Test
    void testValidacionCuenta() {
        Cuenta cuenta = new Cuenta("98765", "Juan", "02");
        ValidadorCuentas validador = new ValidadorCuentas(List.of("01", "02"));
        assertTrue(validador.esCuentaValida(cuenta));
    }

    @Test
    void testGestorCuentas() {
        GestorCuentas gestor = new GestorCuentas();
        Cuenta cuenta = new Cuenta("12345", "Valeria", "01");
        gestor.crearCuenta(cuenta);

        assertTrue(gestor.consultarCuenta("12345").isPresent());
        gestor.depositar("12345", 1000);
        assertEquals(1000, gestor.consultarCuenta("12345").get().getSaldo());
    }

    @Test
    void testGetTitular() {
        Cuenta cuenta = new Cuenta("54321", "Carlos", "03");
        assertEquals("Carlos", cuenta.getTitular());
    }

    @Test
    void testToString() {
        Cuenta cuenta = new Cuenta("67890", "Ana", "04");
        cuenta.depositar(250.0);
        String esperado = "67890 - Ana -> $250.0";
        assertEquals(esperado, cuenta.toString());
    }

    @Test
    void testRetiroInvalido() {
        Cuenta cuenta = new Cuenta("12345", "Valeria", "01");
        cuenta.depositar(100);

        boolean exito = cuenta.retirar(200);
        assertFalse(exito);
        assertEquals(100, cuenta.getSaldo());

        boolean exitoNegativo = cuenta.retirar(-50);
        assertFalse(exitoNegativo);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void testDepositoInvalido() {
        Cuenta cuenta = new Cuenta("12345", "Valeria", "01");

        // Intentar depositar un monto negativo
        cuenta.depositar(-100);
        assertEquals(0, cuenta.getSaldo());

        // Intentar depositar cero
        cuenta.depositar(0);
        assertEquals(0, cuenta.getSaldo());
    }

}
