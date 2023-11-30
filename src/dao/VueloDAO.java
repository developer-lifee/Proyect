package dao;

import model.Vuelo;
import util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.AerolineaDAO;
import model.Aerolinea;

        
public class VueloDAO {

    // Método para agregar un vuelo a la base de datos
    public void agregarVuelo(Vuelo vuelo) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO Flights (AirlineID, FlightCode, DepartureAirport, ArrivalAirport, DepartureTime, ArrivalTime, Price) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, vuelo.getAerolinea().getId());
            pstmt.setString(2, vuelo.getCodigoVuelo());
            pstmt.setString(3, vuelo.getOrigen());
            pstmt.setString(4, vuelo.getDestino());
            pstmt.setTimestamp(5, new Timestamp(vuelo.getHoraSalida().getTime()));
            pstmt.setTimestamp(6, new Timestamp(vuelo.getHoraLlegada().getTime()));
            pstmt.setDouble(7, vuelo.getPrecio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    // Método para obtener todos los vuelos de la base de datos
    public List<Vuelo> obtenerVuelos() {
        List<Vuelo> vuelos = new ArrayList<>();
        try (Connection con = ConexionDB.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Flights")) {
            while (rs.next()) {
                int id = rs.getInt("FlightID");
                int airlineID = rs.getInt("AirlineID");
                String flightCode = rs.getString("FlightCode");
                String departureAirport = rs.getString("DepartureAirport");
                String arrivalAirport = rs.getString("ArrivalAirport");
                Timestamp departureTime = rs.getTimestamp("DepartureTime");
                Timestamp arrivalTime = rs.getTimestamp("ArrivalTime");
                double price = rs.getDouble("Price");

                // Obtener la aerolínea relacionada desde la base de datos o usar un DAO de aerolíneas para obtenerla
                AerolineaDAO aerolineaDAO = new AerolineaDAO();
                Aerolinea aerolinea = aerolineaDAO.obtenerAerolineaPorID(airlineID);

                Vuelo vuelo = new Vuelo(id, aerolinea, flightCode, departureAirport, arrivalAirport, departureTime, arrivalTime, price);
                vuelos.add(vuelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vuelos;
    }
    
// Método en VueloDAO para obtener vuelos por aerolínea
  public List<Vuelo> obtenerVuelosPorAerolinea(String nombreAerolinea) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT f.* FROM Flights f JOIN Airlines a ON f.AirlineID = a.AirlineID WHERE a.Name = ?";
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombreAerolinea);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Vuelo vuelo = new Vuelo();
                    vuelo.setId(rs.getInt("FlightID"));
                    vuelo.setCodigoVuelo(rs.getString("FlightCode"));
                    vuelo.setOrigen(rs.getString("DepartureAirport"));
                    vuelo.setDestino(rs.getString("ArrivalAirport"));
                    vuelo.setHoraSalida(rs.getTimestamp("DepartureTime"));
                    vuelo.setHoraLlegada(rs.getTimestamp("ArrivalTime"));
                    vuelo.setPrecio(rs.getDouble("Price"));
                    
                    // Puedes establecer la aerolínea asociada si es necesario
                    // vuelo.setAerolinea(aerolinea);
                    
                    vuelos.add(vuelo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vuelos;
    }
    //metodo para obtener vuelos  por origen y destino 
  
  public List<Vuelo> obtenerVuelosPorRuta(String origen, String destino) {
    List<Vuelo> vuelos = new ArrayList<>();
    String sql = "SELECT * FROM Flights WHERE DepartureAirport = ? AND ArrivalAirport = ?";
    try (Connection con = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, origen);
        pstmt.setString(2, destino);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setId(rs.getInt("FlightID"));
                vuelo.setCodigoVuelo(rs.getString("FlightCode"));
                vuelo.setOrigen(rs.getString("DepartureAirport"));
                vuelo.setDestino(rs.getString("ArrivalAirport"));
                vuelo.setHoraSalida(rs.getTimestamp("DepartureTime"));
                vuelo.setHoraLlegada(rs.getTimestamp("ArrivalTime"));
                vuelo.setPrecio(rs.getDouble("Price"));
                vuelos.add(vuelo);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return vuelos;
}

    // Método para actualizar un vuelo en la base de datos
    public void actualizarVuelo(Vuelo vuelo) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("UPDATE Flights SET AirlineID=?, FlightCode=?, DepartureAirport=?, ArrivalAirport=?, DepartureTime=?, ArrivalTime=?, Price=? WHERE FlightID=?")) {
            pstmt.setInt(1, vuelo.getAerolinea().getId());
            pstmt.setString(2, vuelo.getCodigoVuelo());
            pstmt.setString(3, vuelo.getOrigen());
            pstmt.setString(4, vuelo.getDestino());
            pstmt.setTimestamp(5, new Timestamp(vuelo.getHoraSalida().getTime()));
            pstmt.setTimestamp(6, new Timestamp(vuelo.getHoraLlegada().getTime()));
            pstmt.setDouble(7, vuelo.getPrecio());
            pstmt.setInt(8, vuelo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para obtener un vuelo por su ID
public Vuelo obtenerVueloPorID(int id) {
    Vuelo vuelo = null;
    try (Connection con = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Flights WHERE FlightID=?")) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            int airlineID = rs.getInt("AirlineID");
            String flightCode = rs.getString("FlightCode");
            String departureAirport = rs.getString("DepartureAirport");
            String arrivalAirport = rs.getString("ArrivalAirport");
            Timestamp departureTime = rs.getTimestamp("DepartureTime");
            Timestamp arrivalTime = rs.getTimestamp("ArrivalTime");
            double price = rs.getDouble("Price");

            // Obtener la aerolínea relacionada desde la base de datos o usar un DAO de aerolíneas para obtenerla
            AerolineaDAO aerolineaDAO = new AerolineaDAO();
            Aerolinea aerolinea = aerolineaDAO.obtenerAerolineaPorID(airlineID);

            vuelo = new Vuelo(id, aerolinea, flightCode, departureAirport, arrivalAirport, departureTime, arrivalTime, price);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return vuelo;
}



    // Método para eliminar un vuelo de la base de datos
    public void eliminarVuelo(int id) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM Flights WHERE FlightID=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
