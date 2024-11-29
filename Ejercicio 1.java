public class Main {
    public static void main(String[] args) {
        int numero = 10;
        System.out.println("Valor original: " + numero);
        
        cambiarValor(numero);
        
        System.out.println("Valor después de intentar cambiar: " + numero);
    }

    public static void cambiarValor(int num) {
        num = 20; // Intentamos cambiar el valor
        System.out.println("Valor dentro del método: " + num);
    }
}
Ejercicio 1