import java.util.ArrayList;
import java.util.List;

class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void editar(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    public void completar() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return descripcion + (completada ? " (completada)" : "");
    }
}

class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void crearTarea(String descripcion) {
        Tarea tarea = new Tarea(descripcion);
        tareas.add(tarea);
        System.out.println("Tarea creada: " + descripcion);
    }

    public void editarTarea(int index, String nuevaDescripcion) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).editar(nuevaDescripcion);
            System.out.println("Tarea editada: " + nuevaDescripcion);
        } else {
            System.out.println("Índice de tarea no válido.");
        }
    }

    public void completarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).completar();
            System.out.println("Tarea completada: " + tareas.get(index).getDescripcion());
        } else {
            System.out.println("Índice de tarea no válido.");
        }
    }

    public void listarTareas() {
        System.out.println("Lista de Tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        gestor.crearTarea("Comprar leche");
        gestor.crearTarea("Estudiar Java");
        gestor.listarTareas();
        gestor.editarTarea(1, "Estudiar Java y patrones de diseño");
        gestor.completarTarea(0);
        gestor.listarTareas();
    }
}