package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // JDBC URL, nombre de usuario y contraseña de MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/AirlineDB"; // AirlineDB es el nombre de la base de datos
    private static final String USER = "root"; // Usuario por defecto de XAMPP
    private static final String PASS = ""; // Contraseña por defecto de XAMPP es vacía

    // Registra el driver JDBC y establece la conexión
    public static Connection obtenerConexion() {
        Connection con = null;
        try {
            // Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar las excepciones de SQL y ClassNotFound
            e.printStackTrace();
        }
        return con;
    }
}
