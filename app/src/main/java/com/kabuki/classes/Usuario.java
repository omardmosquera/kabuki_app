package com.kabuki.classes;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String contrasena;

    public Usuario() {

    }

    public Usuario(
            String correo,
            String contrasena
    ) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(
            String nombre,
            String correo,
            String direccion,
            String telefono,
            String contrasena
    ) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Usuario(
            int id,
            String nombre,
            String correo,
            String direccion,
            String telefono,
            String contrasena
    ) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public int getId() {
        return this.id;
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

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
