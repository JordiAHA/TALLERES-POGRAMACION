import java.sql.*;
import java.util.Scanner;

public class GestionUsuarios {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Comandos: agregar, eliminar, actualizar, mostrar, salir");
            System.out.print("Ingresa un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "agregar":
                    agregarUsuario(scanner);
                    break;
                case "eliminar":
                    eliminarUsuario(scanner);
                    break;
                case "actualizar":
                    actualizarUsuario(scanner);
                    break;
                case "mostrar":
                    mostrarUsuarios();
                    break;
                case "salir":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intenta de nuevo.");
                    break;
            }
        } while (!comando.equals("salir"));

        scanner.close();
    }

    private static void agregarUsuario(Scanner scanner) {
        System.out.print("Ingresa el nombre del usuario: ");
        String nombre = scanner.nextLine();
        String sql = "INSERT INTO usuarios (nombre) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            System.out.println("Usuario agregado.");
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingresa el ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    private static void actualizarUsuario(Scanner scanner) {
        System.out.print("Ingresa el ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingresa el nuevo nombre del usuario: ");
        String nuevoNombre = scanner.nextLine();
        String sql = "UPDATE usuarios SET nombre = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    private static void mostrarUsuarios() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Usuarios:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar usuarios: " + e.getMessage());
        }
    }
}
