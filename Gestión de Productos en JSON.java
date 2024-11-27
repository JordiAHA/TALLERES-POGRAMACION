import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("nombre", nombre);
        json.put("precio", precio);
        return json;
    }

    public static Producto fromJSON(JSONObject json) {
        String nombre = json.getString("nombre");
        double precio = json.getDouble("precio");
        return new Producto(nombre, precio);
    }
}

public class GestionProductos {
    private static final String NOMBRE_ARCHIVO = "productos.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();
        String comando;

        do {
            System.out.println("Comandos: agregar, mostrar, salir");
            System.out.print("Ingresa un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "agregar":
                    agregarProducto(scanner, productos);
                    break;
                case "mostrar":
                    mostrarProductos();
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

    private static void agregarProducto(Scanner scanner, List<Producto> productos) {
        System.out.print("Ingresa el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        guardarProductosEnArchivo(productos);
        System.out.println("Producto agregado.");
    }

    private static void guardarProductosEnArchivo(List<Producto> productos) {
        JSONArray jsonArray = new JSONArray();
        for (Producto producto : productos) {
            jsonArray.put(producto.toJSON());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.write(jsonArray.toString(4)); // Indentación de 4 espacios
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    private static void mostrarProductos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                jsonBuilder.append(linea);
            }

            JSONArray jsonArray = new JSONArray(jsonBuilder.toString());
            System.out.println("Productos guardados:");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                Producto producto = Producto.fromJSON(json);
                System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        } catch (IOException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
        }
    }
}