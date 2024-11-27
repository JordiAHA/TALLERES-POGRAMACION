public class CuentaBancaria {
    public static void main(String[] args) {
        // Cantidad inicial en la cuenta
        double cantidadInicial = 1000.0;
        // Retiro semanal
        double retiroSemanal = 200.0;
        // Número de semanas en un mes
        int semanas = 4;

        // Total retirado en el mes
        double totalRetirado = retiroSemanal * semanas;

        // Dinero restante en la cuenta
        double dineroRestante = cantidadInicial - totalRetirado;

        // Mostrar resultado
        System.out.printf("Dinero restante en la cuenta al final del mes: $%.2f%n", dineroRestante);
    }
}