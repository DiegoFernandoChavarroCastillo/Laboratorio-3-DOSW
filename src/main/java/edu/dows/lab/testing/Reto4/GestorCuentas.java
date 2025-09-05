package edu.dows.lab.testing.Reto4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que gestiona un conjunto de cuentas bancarias.
 * Permite realizar operaciones como crear cuentas, consultarlas,
 * depositar dinero y listar todas las cuentas disponibles.
 */
public class GestorCuentas {
    private final Map<String, Cuenta> cuentas = new HashMap<>();

    /**
     * Crea una nueva cuenta y la agrega al sistema.
     * Si ya existe una cuenta con el mismo número, se sobrescribe.
     */
    public void crearCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    /**
     * Consulta una cuenta a partir de su número.
     */
    public Optional<Cuenta> consultarCuenta(String numeroCuenta) {
        return Optional.ofNullable(cuentas.get(numeroCuenta));
    }

    /**
     * Realiza un depósito en la cuenta indicada.
     * Si la cuenta no existe, no se realiza ninguna acción.
     */
    public void depositar(String numeroCuenta, double monto) {
        cuentas.values().stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .ifPresent(c -> c.depositar(monto));
    }

    /**
     * Devuelve una lista con todas las cuentas registradas en el sistema.
     */
    public List<Cuenta> listarCuentas() {
        return cuentas.values().stream().collect(Collectors.toList());
    }
}
