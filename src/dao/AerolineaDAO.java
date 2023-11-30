
package dao;

import model.Aerolinea;
import util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AerolineaDAO {
    // Método para agregar una aerolínea a la base de datos
    public void agregarAerolinea(Aerolinea aerolinea) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO Airlines (Name, Code, CountryOfOrigin) VALUES (?, ?, ?)")) {
            pstmt.setString(1, aerolinea.getNombre());
            pstmt.setString(2, aerolinea.getCodigo());
            pstmt.setString(3, aerolinea.getPaisOrigen());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las aerolíneas de la base de datos
    public List<Aerolinea> obtenerAerolineas() {
        List<Aerolinea> aerolineas = new ArrayList<>();
        try (Connection con = ConexionDB.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Airlines")) {
            while (rs.next()) {
                int id = rs.getInt("AirlineID");
                String nombre = rs.getString("Name");
                String codigo = rs.getString("Code");
                String paisOrigen = rs.getString("CountryOfOrigin");

                Aerolinea aerolinea = new Aerolinea(id, nombre, codigo, paisOrigen);
                aerolineas.add(aerolinea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aerolineas;
    }

    // Método para actualizar una aerolínea en la base de datos
    public void actualizarAerolinea(Aerolinea aerolinea) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("UPDATE Airlines SET Name=?, Code=?, CountryOfOrigin=? WHERE AirlineID=?")) {
            pstmt.setString(1, aerolinea.getNombre());
            pstmt.setString(2, aerolinea.getCodigo());
            pstmt.setString(3, aerolinea.getPaisOrigen());
            pstmt.setInt(4, aerolinea.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metodo para obtener aerolinea por id en la base de datos
    public Aerolinea obtenerAerolineaPorID(int id) {
    Aerolinea aerolinea = null;
    try (Connection con = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Airlines WHERE AirlineID=?")) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("Name");
            String codigo = rs.getString("Code");
            String paisOrigen = rs.getString("CountryOfOrigin");
            
            aerolinea = new Aerolinea(id, nombre, codigo, paisOrigen);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return aerolinea;
}

    // Método para eliminar una aerolínea de la base de datos
    public void eliminarAerolinea(int id) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM Airlines WHERE AirlineID=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}