package com.kabuki.classes;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reserva {
    private int id;
    private int productoId;
    private int usuarioId;
    private String talla;
    private int cantidad;
    private String telefono;
    private String direccion;

    public Reserva(int productoId,
                   int usuarioId,
                   String talla,
                   int cantidad,
                   String telefono,
                   String direccion) {
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.talla = talla;
        this.cantidad = cantidad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return this.productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTalla() {

        return this.talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidad() {

        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTelefono() {

        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
