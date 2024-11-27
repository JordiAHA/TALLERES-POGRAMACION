public class IntercambioValores {
    // Método que intenta intercambiar los valores de dos enteros
    public static void intercambiar(int x, int y) {
        // Intentamos intercambiar los valores, pero esto no afectará a las variables originales
        int temp = x;
        x = y;
        y = temp;
        
        // Imprimimos los valores dentro del método para mostrar el intercambio local
        System.out.println("Dentro del método intercambiar:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    
    public static void main(String[] args) {
        // Creamos dos variables enteras
        int a = 5;
        int b = 10;
        
        // Imprimimos los valores originales
        System.out.println("Antes de llamar al método intercambiar:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        // Llamamos al método intercambiar
        intercambiar(a, b);
        
        // Imprimimos los valores después de llamar al método
        System.out.println("Después de llamar al método intercambiar:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}