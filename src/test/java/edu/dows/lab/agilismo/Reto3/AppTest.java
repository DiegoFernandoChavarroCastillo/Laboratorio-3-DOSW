package edu.dows.lab.agilismo.Reto3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testHistoriaUsuario() {
        HistoriaUsuario h = new HistoriaUsuario("US-01", "Probar cobertura");

        assertEquals("US-01", h.getId());
        assertEquals("Probar cobertura", h.getDescripcion());

        // Por defecto es -1
        assertEquals(-1, h.getEstimacionFinal());

        h.setEstimacionFinal(8);
        assertEquals(8, h.getEstimacionFinal());
    }

    @Test
    void testVotacionEsValido() {
        assertTrue(Votacion.esValido(1));
        assertTrue(Votacion.esValido(13));
        assertFalse(Votacion.esValido(4));
        assertFalse(Votacion.esValido(-1));
    }

    @Test
    void testVotacionHayConsenso() {
        assertFalse(Votacion.hayConsenso(null));
        assertFalse(Votacion.hayConsenso(new int[]{}));
        assertTrue(Votacion.hayConsenso(new int[]{5, 5, 5}));
        assertFalse(Votacion.hayConsenso(new int[]{5, 3, 5}));
    }
}
