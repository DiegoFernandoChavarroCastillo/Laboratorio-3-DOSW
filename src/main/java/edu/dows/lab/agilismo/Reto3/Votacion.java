package edu.dows.lab.agilismo.Reto3;
import java.util.Arrays;

public class Votacion {
    public static final int[] FIBONACCI = {1, 2, 3, 5, 8, 13};

    public static boolean esValido(int v) {
        for (int n : FIBONACCI) if (n == v) return true;
        return false;
    }

    public static boolean hayConsenso(int[] votos) {
        if (votos == null || votos.length == 0) return false;
        int first = votos[0];
        for (int v : votos) if (v != first) return false;
        return true;
    }

    public static String votosAString(int[] votos) {
        return Arrays.toString(votos);
    }

    public static String secuenciaPermitida() {
        return Arrays.toString(FIBONACCI);
    }


}
