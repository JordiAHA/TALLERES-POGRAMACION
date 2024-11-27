import java.text.DecimalFormat;

// Excepción personalizada para fondos insuficientes
class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}

// Clase Cuenta Bancaria
class CuentaBancaria {
    // Atributos de la cuenta
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito de $" + formatearDinero(cantidad) + " realizado.");
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    // Método para retirar dinero con manejo de excepción personalizada
    public void retirar(double cantidad) throws FondosInsuficientesException {
        // Verificar si hay fondos suficientes
        if (cantidad > saldo) {
            // Lanzar excepción personalizada si los fondos son insuficientes
            throw new FondosInsuficientesException(
                "Fondos insuficientes. Saldo actual: $" + formatearDinero(saldo) + 
                ", Monto de retiro solicitado: $" + formatearDinero(cantidad)
            );
        }

        // Realizar el retiro si hay fondos suficientes
        saldo -= cantidad;
        System.out.println("Retiro de $" + formatearDinero(cantidad) + " realizado.");
    }

    // Método para consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Método para formatear dinero con dos decimales
    private String formatearDinero(double cantidad) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(cantidad);
    }

    // Método para obtener información de la cuenta
    public String informacionCuenta() {
        return "Titular: " + titular + ", Saldo actual: $" + formatearDinero(saldo);
    }
}

// Clase principal para demostrar el funcionamiento
public class SimulacionBancaria {
    public static void main(String[] args) {
        try {
            // Crear una cuenta bancaria
            CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000.00);
            
            // Mostrar información inicial de la cuenta
            System.out.println("Información inicial de la cuenta:");
            System.out.println(cuenta.informacionCuenta());
            
            // Realizar un depósito
            cuenta.depositar(500.00);
            
            // Realizar un retiro exitoso
            cuenta.retirar(200.00);
            
            // Mostrar saldo después de las operaciones
            System.out.println("\nSaldo actual: $" + cuenta.consultarSaldo());
            
            // Intentar retirar más dinero del disponible
            cuenta.retirar(2000.00);
        
        } catch (FondosInsuficientesException e) {
            // Capturar y mostrar la excepción de fondos insuficientes
            System.out.println("Error en la transacción: " + e.getMessage());
        }
    }
}
