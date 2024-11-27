import java.util.ArrayList;
import java.util.Scanner;

public class GestionLista {
    private ArrayList<String> lista;

    public GestionLista() {
        lista = new ArrayList<>();
    }

    public void agregarElemento(String elemento) {
        lista.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }

    public void mostrarElemento(int indice) {
        try {
            String elemento = lista.get(indice);
            System.out.println("Elemento en índice " + indice + ": " + elemento);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de los límites. Por favor, intenta con un índice válido.");
        }
    }

    public void mostrarLista() {
        System.out.println("Lista de elementos:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    public static void main(String[] args) {
        GestionLista gestion = new GestionLista();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Comandos: agregar, mostrar, salir");
            System.out.print("Ingresa un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "agregar":
                    System.out.print("Ingresa el elemento a agregar: ");
                    String elemento = scanner.nextLine();
                    gestion.agregarElemento(elemento);
                    break;
                case "mostrar":
                    System.out.print("Ingresa el índice del elemento a mostrar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    gestion.mostrarElemento(indice);
                    break;
                case "salir":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intenta de nuevo.");
                    break;
            }

            gestion.mostrarLista();

        } while (!comando.equals("salir"));

        scanner.close();
    }
}