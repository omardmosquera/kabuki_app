package com.kabuki.classes;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String tallas;
    private boolean disponibilidad;

    public Producto(
            int id,
            String nombre,
            String descripcion,
            String tallas,
            boolean disponibilidad
    ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTallas() {
        return this.tallas;
    }

    public void setTallas(String tallas) {
        this.tallas = tallas;
    }

    public boolean getDisponibilidad() {
        return this.disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
