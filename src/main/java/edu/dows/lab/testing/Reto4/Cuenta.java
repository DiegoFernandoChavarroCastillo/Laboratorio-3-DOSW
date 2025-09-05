package edu.dows.lab.testing.Reto4;

/**
 * Representa una cuenta bancaria con sus datos principales.
 * Cada cuenta está asociada a un número de cuenta único, un titular y un banco.
 * Permite realizar operaciones como depósitos y retiros de dinero.
 *
 */
public class Cuenta {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;
    private final String codigoBanco;

    /**
     * Crea una nueva cuenta bancaria con saldo inicial en 0.
     */
    public Cuenta(String numeroCuenta, String titular, String codigoBanco) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.codigoBanco = codigoBanco;
        this.saldo = 0.0;
    }

    /**
     * Obtiene el número único de la cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene el código del banco al que pertenece la cuenta.
     */
    public String getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * Realiza un depósito en la cuenta.
     * El depósito solo se efectúa si el monto es mayor que 0.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    /**
     * Retira dinero de la cuenta si hay saldo suficiente.
     */
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    /**
     * Devuelve una representación en texto de la cuenta.
     */
    @Override
    public String toString() {
        return numeroCuenta + " - " + titular + " -> $" + saldo;
    }
}
