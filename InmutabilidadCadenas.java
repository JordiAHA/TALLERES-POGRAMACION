public class InmutabilidadCadenas {
    // Método que intenta modificar una cadena
    public static void modificarCadena(String texto) {
        // Intentamos modificar la cadena
        texto = texto.toUpperCase();
        
        // Imprimimos la cadena dentro del método
        System.out.println("Dentro del método modificarCadena:");
        System.out.println("texto = " + texto);
    }
    
    public static void main(String[] args) {
        // Creamos una cadena de texto
        String mensaje = "hola mundo";
        
        // Mostramos el valor original
        System.out.println("Antes de llamar al método:");
        System.out.println("mensaje = " + mensaje);
        
        // Llamamos al método para intentar modificar la cadena
        modificarCadena(mensaje);
        
        // Mostramos el valor después de llamar al método
        System.out.println("Después de llamar al método:");
        System.out.println("mensaje = " + mensaje);
        
        // Demostramos cómo crear una nueva cadena
        String mensajeModificado = mensaje.toUpperCase();
        
        // Mostramos la nueva cadena
        System.out.println("Cadena modificada (nueva instancia):");
        System.out.println("mensajeModificado = " + mensajeModificado);
        System.out.println("mensaje original = " + mensaje);
    }
}