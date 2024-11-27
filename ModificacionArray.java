public class ModificacionArray {
    // Método para modificar los valores del array
    public static void modificarArray(int[] arr) {
        // Modificamos algunos elementos del array
        // Aumentamos cada elemento por 10
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
        
        // Imprimimos el array dentro del método
        System.out.println("Dentro del método modificarArray:");
        imprimirArray(arr);
    }
    
    // Método auxiliar para imprimir el array
    public static void imprimirArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Creamos un array de enteros
        int[] numeros = {1, 2, 3, 4, 5};
        
        // Mostramos el array original
        System.out.println("Antes de modificar:");
        imprimirArray(numeros);
        
        // Llamamos al método para modificar el array
        modificarArray(numeros);
        
        // Mostramos el array después de la modificación
        System.out.println("Después de modificar:");
        imprimirArray(numeros);
    }
}