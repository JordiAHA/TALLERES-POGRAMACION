import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejoExcepcionesJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Intentar establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");

            // Realizar operaciones en la base de datos
            realizarOperaciones(connection);

        } catch (SQLException e) {
            // Manejo de excepciones específicas
            manejarExcepcion(e);
        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    private static void realizarOperaciones(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Tabla 'usuarios' creada o ya existe.");
        } catch (SQLException e) {
            manejarExcepcion(e);
        }
    }

    private static void manejarExcepcion(SQLException e) {
        switch (e.getErrorCode()) {
            case 1045:
                System.out.println("Error: Acceso denegado. Verifica tu usuario y contraseña.");
                break;
            case 1049:
                System.out.println("Error: Base de datos desconocida. Verifica el nombre de la base de datos.");
                break;
            case 0:
                System.out.println("Error: No se pudo establecer la conexión. Verifica el servidor.");
                break;
            default:
                System.out.println("Error SQL: " + e.getMessage());
                break;
        }
    }
}