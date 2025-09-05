package edu.dows.lab.testing.Reto4;

import java.util.List;

/**
 * Clase que se encarga de validar las cuentas bancarias
 * en base a un listado de códigos de bancos permitidos.
 */
public class ValidadorCuentas {
    private final List<String> codigosBancosValidos;

    /**
     * Constructor del ValidadorCuentas.
     */
    public ValidadorCuentas(List<String> codigosBancosValidos) {
        this.codigosBancosValidos = codigosBancosValidos;
    }

    /**
     * Verifica si una cuenta pertenece a un banco válido.
     */
    public boolean esCuentaValida(Cuenta cuenta) {
        return codigosBancosValidos.stream()
                .anyMatch(codigo -> cuenta.getCodigoBanco().equals(codigo));
    }
}
