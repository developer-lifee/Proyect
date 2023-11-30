package model;

public class Aerolinea {
    private int id;
    private String nombre;
    private String codigo;
    private String paisOrigen;

    // Constructor
    public Aerolinea(int id, String nombre, String codigo, String paisOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.paisOrigen = paisOrigen;
    }

    // Getter para id
    public int getId() {
        return id;
    }

    // Setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para codigo
    public String getCodigo() {
        return codigo;
    }

    // Setter para codigo
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter para paisOrigen
    public String getPaisOrigen() {
        return paisOrigen;
    }

    // Setter para paisOrigen
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
