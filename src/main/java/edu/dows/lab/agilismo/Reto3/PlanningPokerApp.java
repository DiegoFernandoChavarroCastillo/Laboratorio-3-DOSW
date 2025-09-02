package edu.dows.lab.agilismo.Reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanningPokerApp {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        // HISTORIAS (traídas del RETO 2 — ya proporcionadas)
        List<HistoriaUsuario> historias = new ArrayList<>();
        historias.add(new HistoriaUsuario("US-01", "Como cliente, quiero crear una cuenta bancaria válida, para poder realizar operaciones financieras."));
        historias.add(new HistoriaUsuario("US-02", "Como cliente, quiero validar que mi cuenta cumpla con las reglas, para asegurarme de que sea aceptada por el sistema."));
        historias.add(new HistoriaUsuario("US-03", "Como cliente, quiero consultar el saldo de mi cuenta, para saber cuánto dinero tengo disponible."));
        historias.add(new HistoriaUsuario("US-04", "Como cliente, quiero realizar depósitos en mi cuenta, para incrementar mi saldo y usarlo cuando lo necesite."));
        historias.add(new HistoriaUsuario("US-05", "Como banco, quiero registrar mis códigos de identificación, para que el sistema pueda validar si una cuenta pertenece a mi entidad."));
        historias.add(new HistoriaUsuario("US-06", "Como banco, quiero que el sistema valide los primeros dos dígitos de la cuenta, para asegurar que las cuentas pertenezcan a un banco autorizado."));

        System.out.println("=== Planning Poker ===");
        System.out.println("Secuencia permitida: " + Votacion.secuenciaPermitida());
        int integrantes = pedirNumeroIntegrantes(sc);



        for (HistoriaUsuario historia : historias) {
            System.out.println("\n--- Historia: " + historia.getId() + " ---");
            System.out.println(historia.getDescripcion());

            boolean consenso = false;
            int[] votos = new int[integrantes];

            while (!consenso) {
                System.out.println("\nIngrese los votos (valores permitidos " + Votacion.secuenciaPermitida() + "):");



                for (int i = 0; i < integrantes; i++) {
                    votos[i] = pedirVoto(sc, i + 1);
                }


                System.out.println("Votos: " + Votacion.votosAString(votos));


                if (Votacion.hayConsenso(votos)) {
                    consenso = true;
                    historia.setEstimacionFinal(votos[0]);
                    System.out.println("Consenso alcanzado: " + votos[0] + " puntos");
                } else {
                    System.out.println("Votos divergentes – vuelvan a votar");
                    System.out.println("Presione ENTER cuando estén listos para votar de nuevo");
                    sc.nextLine();
                    sc.nextLine();
                }
            }
        }


        System.out.println("\n=== Resumen Final de Estimaciones ===");
        for (HistoriaUsuario h : historias) {
            System.out.println(h);
        }

        sc.close();
    }

    private static int pedirNumeroIntegrantes(Scanner sc) {
        int n = 0;
        while (n <= 0) {
            System.out.print("Ingrese el número de integrantes del equipo : ");
            String line = sc.nextLine();
            try {
                n = Integer.parseInt(line.trim());
                if (n <= 0) System.out.println("Debe ser un número mayor que 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
        return n;
    }

    private static int pedirVoto(Scanner sc, int miembro) {
        while (true) {
            System.out.print("Integrante " + miembro + " vote: ");
            String texto = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(texto);
                if (Votacion.esValido(v)) return v;
                System.out.println("Voto inválido. Valores permitidos: " + Votacion.secuenciaPermitida());
            } catch (NumberFormatException ex) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }
}
