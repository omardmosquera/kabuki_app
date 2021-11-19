package com.kabuki.MySQL;

import android.content.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

import android.graphics.Color;
import android.os.StrictMode;

import com.kabuki.classes.Producto;
import com.kabuki.classes.Usuario;

public class MySQL {
    private static final String url = "jdbc:mysql://192.168.1.7:3306/kabuki";
    private static final String user = "kabuki";
    private static final String pass = "kabuki";

    private Connection connection = null;
    private Boolean isConnect = false;

    public MySQL() {
    }

    public void createConexión(Context ctx) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
            isConnect = true;
        } catch (Exception ex) {
            new SweetAlertDialog(ctx)
                    .setTitleText("Error al comprobar las credenciales:" + ex.getMessage())
                    .show();
        }
    }

    public LinkedList<Producto> getProducts(Context ctx) {
        createConexión(ctx);

        LinkedList<Producto> productos = new LinkedList<Producto>();

        if (isConnect) {
            String query = "SELECT * FROM productos";

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    productos.add(new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("tallas"),
                            rs.getBoolean("disponibilidad")
                    ));
                }

                st.close();
            } catch (Exception ex) {
                new SweetAlertDialog(ctx)
                        .setTitleText("Error al realizar la consulta de productos:" + ex.getMessage())
                        .show();
            }
        }

        return productos;
    }

    public int registerUser(Usuario usuario, Context ctx) {
        createConexión(ctx);

        int rs = -1;

        if (isConnect) {
            String query = "INSERT INTO usuarios (" +
                    "nombre, " +
                    "correo, " +
                    "direccion, " +
                    "telefono, " +
                    "contrasena) " +
                    "VALUES (\'" + usuario.getNombre() + "\', " +
                    "\'" + usuario.getCorreo() + "\', " +
                    "\'" + usuario.getDireccion() + "\', " +
                    "\'" + usuario.getTelefono() + "\', " +
                    "\'" + usuario.getContrasena() + "\')";

            try {
                Statement st = connection.createStatement();
                rs = st.executeUpdate(query);
                st.close();
            } catch (Exception ex) {
                new SweetAlertDialog(ctx)
                        .setTitleText("Error al registrar al usuario:" + ex.getMessage())
                        .show();
            }
        }

        return rs;
    }

    public Usuario loginUser(Usuario usuario, Context ctx) {
        createConexión(ctx);

        Usuario usuarioQ = new Usuario();

        if (isConnect) {
            String query = "SELECT * FROM usuarios " +
                    "WHERE correo = \'" + usuario.getCorreo() + "\' AND " +
                    "contrasena = \'" + usuario.getContrasena() + "\'";

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    usuarioQ.setId(rs.getInt("id"));
                    usuarioQ.setNombre(rs.getString("nombre"));
                    usuarioQ.setCorreo(rs.getString("correo"));
                    usuarioQ.setDireccion(rs.getString("direccion"));
                    usuarioQ.setTelefono(rs.getString("telefono"));
                    usuarioQ.setContrasena(rs.getString("contrasena"));
                }

                st.close();
            } catch (Exception ex) {
                new SweetAlertDialog(ctx)
                        .setTitleText("Error al realizar la consulta del usuario:" + ex.getMessage())
                        .show();
            }
        }

        return usuarioQ;
    }

    public int updateUser(Usuario usuario, Context ctx) {
        createConexión(ctx);

        int rs = -1;

        if (isConnect) {
            String query = "UPDATE usuarios " +
                    "SET " +
                    "nombre = \'" + usuario.getNombre() + "\', " +
                    "correo = \'" + usuario.getCorreo() + "\', " +
                    "direccion = \'" + usuario.getDireccion() + "\', " +
                    "telefono = \'" + usuario.getTelefono() + "\', " +
                    "contrasena = \'" + usuario.getContrasena() + "\' " +
                    "WHERE ID = \'" + usuario.getId() + "\'";

            try {
                Statement st = connection.createStatement();
                rs = st.executeUpdate(query);

                st.close();
            } catch (Exception ex) {
                new SweetAlertDialog(ctx)
                        .setTitleText("Error al actualizar el usuario:" + ex.getMessage())
                        .show();
            }
        }

        return rs;
    }
}
