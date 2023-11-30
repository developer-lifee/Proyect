package dao;

import model.Reserva;
import model.Vuelo; // Agrega esta importación
import util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    // Método para agregar una reserva a la base de datos
    public void agregarReserva(Reserva reserva) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO Reservations (PassengerName, FlightID, ReservationDate) VALUES (?, ?, ?)")) {
            pstmt.setString(1, reserva.getNumeroAsiento());
            pstmt.setInt(2, reserva.getVuelo().getId());
            pstmt.setTimestamp(3, new Timestamp(reserva.getFechaReserva().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para obtener todas las reservas de la base de datos
      
    public  List<Reserva> obtenerReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try (Connection con = ConexionDB.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Reservations")) {
            while (rs.next()) {
                int id = rs.getInt("ReservationID");
                String nombrePasajero = rs.getString("PassengerName");
                int flightID = rs.getInt("FlightID");
                Timestamp reservationDate = rs.getTimestamp("ReservationDate");

                // Obtener el vuelo relacionado desde la base de datos o usar un DAO de vuelos para obtenerlo
                VueloDAO vueloDAO = new VueloDAO();
                Vuelo vuelo = vueloDAO.obtenerVueloPorID(flightID);

                Reserva reserva = new Reserva(id, vuelo, nombrePasajero, new Date(reservationDate.getTime()));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
  
   

        
    }
   public List<Reserva> obtenerReservasPorIDVuelo(int idVuelo) {
    List<Reserva> reservas = new ArrayList<>();
    String sql = "SELECT * FROM Reservations WHERE FlightID = ?";
    try (Connection con = ConexionDB.obtenerConexion();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setInt(1, idVuelo);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ReservationID");
            String seatNumber = rs.getString("SeatNumber");
            Timestamp reservationDate = rs.getTimestamp("ReservationDate");

            Vuelo vuelo = new VueloDAO().obtenerVueloPorID(idVuelo);
            Reserva reserva = new Reserva(id, vuelo, seatNumber, new Date(reservationDate.getTime()));
            reservas.add(reserva);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reservas;
}

    // Método para actualizar una reserva en la base de datos
    public void actualizarReserva(Reserva reserva) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("UPDATE Reservations SET PassengerName=?, FlightID=?, ReservationDate=? WHERE ReservationID=?")) {
            pstmt.setString(1, reserva.getNumeroAsiento());
            pstmt.setInt(2, reserva.getVuelo().getId());
            pstmt.setTimestamp(3, new Timestamp(reserva.getFechaReserva().getTime()));
            pstmt.setInt(4, reserva.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una reserva de la base de datos
    public void eliminarReserva(int id) {
        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM Reservations WHERE ReservationID=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
