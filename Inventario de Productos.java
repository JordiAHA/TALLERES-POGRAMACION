import java.util.Scanner;

public class InventarioTienda {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Definir constantes
        final int NUM_PRODUCTOS = 5;

        // Arrays para almacenar los datos de los productos
        String[] nombres = new String[NUM_PRODUCTOS];
        int[] cantidades = new int[NUM_PRODUCTOS];
        double[] precios = new double[NUM_PRODUCTOS];

        // Entrada de datos
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            System.out.print("Ingrese la cantidad en inventario: ");
            cantidades[i] = scanner.nextInt();

            System.out.print("Ingrese el precio por unidad: ");
            precios[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
        }

        // Calcular y mostrar el valor total del inventario
        double valorTotalInventario = 0;

        System.out.println("\nReporte Final:");
        for (int i = 0; i < NUM_PRODUCTOS; i++) {
            double valorTotalProducto = cantidades[i] * precios[i];
            valorTotalInventario += valorTotalProducto;
            System.out.printf("Producto: %s - Cantidad: %d - Precio por unidad: %.2f - Valor total: %.2f%n",
                    nombres[i], cantidades[i], precios[i], valorTotalProducto);
        }

        // Mostrar el valor total del inventario
        System.out.printf("Valor total del inventario: %.2f%n", valorTotalInventario);

        // Opción para actualizar la cantidad de un producto
        System.out.print("\n¿Desea actualizar la cantidad de un producto? (sí/no): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("sí")) {
            System.out.print("Ingrese el nombre del producto a actualizar: ");
            String productoActualizar = scanner.nextLine();
            boolean encontrado = false;

            for (int i = 0; i < NUM_PRODUCTOS; i++) {
                if (nombres[i].equalsIgnoreCase(productoActualizar)) {
                    System.out.print("Ingrese la nueva cantidad: ");
                    cantidades[i] = scanner.nextInt();
                    encontrado = true;
                    System.out.println("Cantidad actualizada.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado.");
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}
