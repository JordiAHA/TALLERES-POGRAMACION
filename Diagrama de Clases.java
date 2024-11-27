import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado: " + titulo);
        } else {
            System.out.println("Libro no disponible.");
        }
    }

    public void devolver() {
        disponible = true;
        System.out.println("Libro devuelto: " + titulo);
    }
}

class Usuario {
    private String nombre;
    private String idUsuario;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.librosPrestados = new ArrayList<>();
    }

    public void solicitarPrestamo(Libro libro) {
        libro.prestar();
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
        librosPrestados.remove(libro);
    }
}

class Bibliotecario {
    private String nombre;
    private String idBibliotecario;
    private List<Libro> librosGestionados;

    public Bibliotecario(String nombre, String idBibliotecario) {
        this.nombre = nombre;
        this.idBibliotecario = idBibliotecario;
        this.librosGestionados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosGestionados.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    public void eliminarLibro(Libro libro) {
        librosGestionados.remove(libro);
        System.out.println("Libro eliminado: " + libro.getTitulo());
    }
}

class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date(); // Fecha actual
    }
}