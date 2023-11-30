package model;

import java.util.Date;

public class Reserva {
    private int id;
    private Vuelo vuelo; // Asociación con Vuelo
    private String numeroAsiento;
    private Date fechaReserva;

    // Constructor vacío
    public Reserva() {
        // Constructor vacío por defecto
    }

    // Constructor con todos los atributos
    public Reserva(int id, Vuelo vuelo, String numeroAsiento, Date fechaReserva) {
        this.id = id;
        this.vuelo = vuelo;
        this.numeroAsiento = numeroAsiento;
        this.fechaReserva = fechaReserva;
    }

    // Getters y setters para todos los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
