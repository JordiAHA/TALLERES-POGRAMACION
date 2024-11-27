import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionNotas {
    private static final String NOMBRE_ARCHIVO = "notas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> notas = new ArrayList<>();
        String comando;

        do {
            System.out.println("Comandos: agregar, mostrar, salir");
            System.out.print("Ingresa un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "agregar":
                    System.out.print("Ingresa la nota: ");
                    String nota = scanner.nextLine();
                    notas.add(nota);
                    guardarNotaEnArchivo(nota);
                    break;
                case "mostrar":
                    mostrarNotasDesdeArchivo();
                    break;
                case "salir":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intenta de nuevo.");
                    break;
            }
        } while (!comando.equals("salir"));

        scanner.close();
    }

    private static void guardarNotaEnArchivo(String nota) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(nota);
            writer.newLine();
            System.out.println("Nota guardada.");
        } catch (IOException e) {
            System.out.println("Error al guardar la nota: " + e.getMessage());
        }
    }

    private static void mostrarNotasDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("Notas guardadas:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
    }
}
