import java.util.Scanner;

public class CalcularMedia {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que introduzca tres números
        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.print("Introduce el tercer número: ");
        double numero3 = scanner.nextDouble();

        // Calcular la media
        double media = (numero1 + numero2 + numero3) / 3;

        // Mostrar el resultado
        System.out.printf("La media de los tres números es: %.2f%n", media);

        // Cerrar el scanner
        scanner.close();
    }
}