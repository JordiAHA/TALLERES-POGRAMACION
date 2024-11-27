import java.util.Scanner;

public class PromedioNumeros {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crear un array para almacenar 5 números
        double[] numeros = new double[5];
        
        // Pedir al usuario que ingrese los números
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble();
        }
        
        // Calcular la suma de los números
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        
        // Calcular el promedio
        double promedio = suma / numeros.length;
        
        // Mostrar el resultado
        System.out.printf("El promedio de los números ingresados es: %.2f%n", promedio);
        
        // Cerrar el scanner
        scanner.close();
    }
}