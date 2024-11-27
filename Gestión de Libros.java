import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor;
    }
}

public class GestionLibros {
    private static final String NOMBRE_ARCHIVO = "libros.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Comandos: agregar, buscar, listar, salir");
            System.out.print("Ingresa un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "agregar":
                    agregarLibro(scanner);
                    break;
                case "buscar":
                    buscarLibro(scanner);
                    break;
                case "listar":
                    listarLibros();
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

    private static void agregarLibro(Scanner scanner) {
        System.out.print("Ingresa el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        Libro libro = new Libro(titulo, autor);
        guardarLibroEnArchivo(libro);
        System.out.println("Libro agregado.");
    }

    private static void guardarLibroEnArchivo(Libro libro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(libro.getTitulo() + "," + libro.getAutor());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el libro: " + e.getMessage());
        }
    }

    private static void buscarLibro(Scanner scanner) {
        System.out.print("Ingresa el título del libro a buscar: ");
        String tituloBuscado = scanner.nextLine();
        boolean encontrado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(tituloBuscado)) {
                    System.out.println("Libro encontrado: " + linea);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Libro no encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
        }
    }

    private static void listarLibros() {
        System.out.println("Lista de libros:");
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al listar los libros: " + e.getMessage());
        }
    }
}
