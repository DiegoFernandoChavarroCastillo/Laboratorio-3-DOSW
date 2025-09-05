package edu.dows.lab.testing.Reto4;

import java.util.List;
import org.junit.jupiter.api.Test;
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
}
