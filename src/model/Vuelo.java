package model;

import java.util.Date;

public class Vuelo {
    private int id;
    private Aerolinea aerolinea; // Asociación con Aerolínea
    private String codigoVuelo;
    private String origen;
    private String destino;
    private Date horaSalida;
    private Date horaLlegada;
    private double precio;

    // Constructor vacío
    public Vuelo() {
        // Constructor vacío por defecto
    }

    // Constructor con todos los atributos
    public Vuelo(int id, Aerolinea aerolinea, String codigoVuelo, String origen, String destino, Date horaSalida, Date horaLlegada, double precio) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precio = precio;
    }
    @Override
public String toString() {
    return "Vuelo{" +
           "id=" + id +
           ", aerolinea='" + aerolinea.getNombre() + '\'' +
           ", codigoVuelo='" + codigoVuelo + '\'' +
           ", origen='" + origen + '\'' +
           ", destino='" + destino + '\'' +
           ", horaSalida=" + horaSalida +
           ", horaLlegada=" + horaLlegada +
           ", precio=" + precio +
           '}';
}


    // Getters y setters para todos los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
