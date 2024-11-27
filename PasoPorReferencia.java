public class PasoPorReferencia {
    // Clase Rectangulo con atributos ancho y alto
    static class Rectangulo {
        // Atributos de la clase
        int ancho;
        int alto;
        
        // Constructor para inicializar el rectángulo
        public Rectangulo(int ancho, int alto) {
            this.ancho = ancho;
            this.alto = alto;
        }
        
        // Método toString para imprimir fácilmente los datos del rectángulo
        @Override
        public String toString() {
            return "Rectángulo [ancho = " + ancho + ", alto = " + alto + "]";
        }
    }
    
    // Método para modificar un rectángulo
    public static void modificarRectangulo(Rectangulo r) {
        // Cambiamos los valores del rectángulo
        r.ancho = 100;
        r.alto = 200;
        
        // Imprimimos los valores dentro del método
        System.out.println("Dentro de modificarRectangulo:");
        System.out.println(r);
    }
    
    public static void main(String[] args) {
        // Creamos un rectángulo inicial
        Rectangulo miRectangulo = new Rectangulo(10, 20);
        
        // Mostramos el rectángulo original
        System.out.println("Antes de modificar:");
        System.out.println(miRectangulo);
        
        // Llamamos al método para modificar el rectángulo
        modificarRectangulo(miRectangulo);
        
        // Mostramos el rectángulo después de la modificación
        System.out.println("Después de modificar:");
        System.out.println(miRectangulo);
    }
}