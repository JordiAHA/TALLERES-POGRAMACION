public class IncrementarEntero {
    // Método que incrementa un entero y lo devuelve
    public static int incrementar(int x) {
        // Incrementamos el valor de x en 1
        x = x + 1;
        
        // Imprimimos el valor dentro del método
        System.out.println("Dentro del método incrementar:");
        System.out.println("x = " + x);
        
        // Devolvemos el valor incrementado
        return x;
    }
    
    public static void main(String[] args) {
        // Creamos una variable entera
        int numero = 5;
        
        // Mostramos el valor original
        System.out.println("Antes de llamar al método:");
        System.out.println("numero = " + numero);
        
        // Llamamos al método sin usar su valor de retorno
        incrementar(numero);
        
        // Mostramos el valor después de llamar al método
        System.out.println("Después de llamar al método sin usar el valor de retorno:");
        System.out.println("numero = " + numero);
        
        // Llamamos al método y asignamos su valor de retorno
        numero = incrementar(numero);
        
        // Mostramos el valor después de usar el valor de retorno
        System.out.println("Después de llamar al método y usar el valor de retorno:");
        System.out.println("numero = " + numero);
    }
}