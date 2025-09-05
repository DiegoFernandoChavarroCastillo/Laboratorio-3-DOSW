package edu.dows.lab.testing.Reto4;

/**
 * Representa una cuenta bancaria con sus datos principales.
 */
public class Cuenta {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;
    private final String codigoBanco;

    public Cuenta(String numeroCuenta, String titular, String codigoBanco) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.codigoBanco = codigoBanco;
        this.saldo = 0.0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numeroCuenta + " - " + titular + " -> $" + saldo;
    }
}
