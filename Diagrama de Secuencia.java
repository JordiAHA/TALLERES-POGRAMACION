class Biblioteca {
    private Bibliotecario bibliotecario;

    public Biblioteca(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void reservarLibro(Usuario usuario, String tituloLibro) {
        bibliotecario.solicitarReserva(usuario, tituloLibro);
    }
}

class Bibliotecario {
    private List<Libro> librosGestionados;

    public Bibliotecario() {
        librosGestionados = new ArrayList<>();
    }

    public void solicitarReserva(Usuario usuario, String tituloLibro) {
        Libro libro = verificarDisponibilidad(tituloLibro);
        if (libro != null && libro.isDisponible()) {
            libro.reservar();
            usuario.confirmarReserva(libro);
        } else {
            usuario.informarNoDisponible();
        }
    }

    public Libro verificarDisponibilidad(String tituloLibro) {
        for (Libro libro : librosGestionados) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                return libro;
            }
        }
        return null; // Libro no encontrado
    }
}

class Libro {
    private String titulo;
    private boolean disponible;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        this.disponible = false;
        System.out.println("Libro reservado: " + titulo);
    }
}

class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void confirmarReserva(Libro libro) {
        System.out.println("Reserva confirmada para el libro: " + libro.getTitulo());
    }

    public void informarNoDisponible() {
        System.out.println("El libro no está disponible para reserva.");
    }
}