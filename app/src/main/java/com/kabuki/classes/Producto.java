package com.kabuki.classes;

import com.mysql.jdbc.Blob;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String tallas;
    private boolean disponibilidad;
    private Blob imagen;

    public Producto(
            int id,
            String nombre,
            String descripcion,
            String tallas,
            boolean disponibilidad,
            Blob imagen
    ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
        this.disponibilidad = disponibilidad;
        this.imagen = imagen;
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

    public Blob getImagen() {
        return this.imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
}
