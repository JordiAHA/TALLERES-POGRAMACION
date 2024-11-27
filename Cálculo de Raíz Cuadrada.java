
import java.util.Scanner;

// Excepción personalizada para números negativos
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

public class CalculadoraRaizCuadrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Solicitar el número al usuario
            System.out.print("Ingrese un número para calcular su raíz cuadrada: ");
            double numero = scanner.nextDouble();
            
            // Calcular y mostrar la raíz cuadrada
            double raizCuadrada = calcularRaizCuadrada(numero);
            System.out.println("La raíz cuadrada de " + numero + " es: " + raizCuadrada);
        
        } catch (NumeroNegativoException e) {
            // Manejar la excepción personalizada de número negativo
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción inesperada
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }
    
    // Método para calcular la raíz cuadrada
    public static double calcularRaizCuadrada(double numero) throws NumeroNegativoException {
        // Verificar si el número es negativo
        if (numero < 0) {
            throw new NumeroNegativoException("No se puede calcular la raíz cuadrada de un número negativo: " + numero);
        }
        
        // Calcular la raíz cuadrada
        return Math.sqrt(numero);
    }
}