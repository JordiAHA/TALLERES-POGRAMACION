class Persona {
    private String nombre;

    // Constructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método para cambiar el nombre
    public void cambiarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Persona
        Persona persona = new Persona("Juan");
        System.out.println("Nombre original: " + persona.getNombre());

        // Cambiar el nombre usando el método
        persona.cambiarNombre("Carlos");
        System.out.println("Nombre después de cambiar: " + persona.getNombre());
    }
}
Ejercicio 2