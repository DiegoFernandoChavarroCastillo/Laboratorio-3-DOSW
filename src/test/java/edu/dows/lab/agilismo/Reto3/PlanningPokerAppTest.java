package edu.dows.lab.agilismo.Reto3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlanningPokerAppTest {

    @Test
    void testPedirNumeroIntegrantesValido() throws Exception {
        String input = "3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Method m = PlanningPokerApp.class.getDeclaredMethod("pedirNumeroIntegrantes", Scanner.class);
        m.setAccessible(true);

        int result = (int) m.invoke(null, sc);
        assertEquals(3, result);
    }

    @Test
    void testPedirNumeroIntegrantesInvalidoYValido() throws Exception {
        String input = "abc\n-2\n2\n"; // primero invalido, luego <0, luego valido
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Method m = PlanningPokerApp.class.getDeclaredMethod("pedirNumeroIntegrantes", Scanner.class);
        m.setAccessible(true);

        int result = (int) m.invoke(null, sc);
        assertEquals(2, result);
    }

    @Test
    void testPedirVotoValido() throws Exception {
        String input = "5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Method m = PlanningPokerApp.class.getDeclaredMethod("pedirVoto", Scanner.class, int.class);
        m.setAccessible(true);

        int voto = (int) m.invoke(null, sc, 1);
        assertEquals(5, voto);
    }

    @Test
    void testPedirVotoInvalidoYValido() throws Exception {
        String input = "abc\n9\n3\n"; // invalido, no permitido, valido
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Method m = PlanningPokerApp.class.getDeclaredMethod("pedirVoto", Scanner.class, int.class);
        m.setAccessible(true);

        int voto = (int) m.invoke(null, sc, 1);
        assertEquals(3, voto);
    }

    @Test
    void testEjecutarConUnIntegrante() {
        // Flujo: 1 integrante -> Historia 1: voto válido -> resto se resuelven rápido
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("1\n"); // numero de integrantes
        // 6 historias con 1 integrante cada una, siempre vota 5
        for (int i = 0; i < 6; i++) {
            inputBuilder.append("5\n");
        }
        InputStream in = new ByteArrayInputStream(inputBuilder.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertDoesNotThrow(PlanningPokerApp::ejecutar);
    }
}


