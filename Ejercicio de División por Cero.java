import java.util.Scanner;

public class DivisionPorCero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Solicitar el primer número
            System.out.print("Ingrese el primer número (dividendo): ");
            int dividendo = scanner.nextInt();
            
            // Solicitar el segundo número
            System.out.print("Ingrese el segundo número (divisor): ");
            int divisor = scanner.nextInt();
            
            // Intentar realizar la división
            int resultado = dividirNumeros(dividendo, divisor);
            
            // Mostrar el resultado de la división
            System.out.println("Resultado de la división: " + resultado);
        
        } catch (ArithmeticException e) {
            // Capturar y manejar específicamente la excepción de división por cero
            System.out.println("Error: No se puede dividir por cero.");
        } catch (Exception e) {
            // Manejar cualquier otra excepción inesperada
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }
    
    // Método separado para realizar la división
    public static int dividirNumeros(int dividendo, int divisor) throws ArithmeticException {
        // Lanzar ArithmeticException si el divisor es cero
        if (divisor == 0) {
            throw new ArithmeticException("División por cero");
        }
        
        // Realizar la división
        return dividendo / divisor;
    }
}