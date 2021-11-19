package com.kabuki.kabukiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.kabuki.MySQL.MySQL;
import com.kabuki.classes.Producto;
import com.kabuki.classes.Reserva;
import com.kabuki.classes.Usuario;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ReserveFragment extends Fragment {

    View fragment;
    Usuario usuario;
    Producto producto;

    public ReserveFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.contact_form, container, false);

        usuario = ((MainActivity) getActivity()).getUsuario();
        producto = ((MainActivity) getActivity()).getProducto();

        Button send = fragment.findViewById(R.id.button_send);
        send.setOnClickListener(v -> send());
        Button cancel = fragment.findViewById(R.id.button_cancel);
        cancel.setOnClickListener(v -> cancel());

        if(usuario != null){
            ((TextInputEditText) fragment.findViewById(R.id.input_name)).setText(usuario.getNombre());
            ((TextInputEditText) fragment.findViewById(R.id.input_mail)).setText(usuario.getCorreo());
        }

        ((TextInputEditText) fragment.findViewById(R.id.input_design)).setText(producto.getId() + "");

        return fragment;
    }

    private void send() {
        String nombre = ((TextInputEditText) fragment.findViewById(R.id.input_name)).getText().toString();
        String correo = ((TextInputEditText) fragment.findViewById(R.id.input_mail)).getText().toString();
        String talla = ((TextInputEditText) fragment.findViewById(R.id.input_size)).getText().toString();
        String cantidadTxt = ((TextInputEditText) fragment.findViewById(R.id.input_amount)).getText().toString();
        String telefono = ((TextInputEditText) fragment.findViewById(R.id.input_phone)).getText().toString();
        String direccion = ((TextInputEditText) fragment.findViewById(R.id.input_address)).getText().toString();
        String diseno = ((TextInputEditText) fragment.findViewById(R.id.input_design)).getText().toString();

        if (nombre.equals("") ||
                correo.equals("") ||
                talla.equals("") ||
                cantidadTxt.equals("") ||
                telefono.equals("") ||
                direccion.equals("") ||
                diseno.equals("")) {
            new SweetAlertDialog(fragment.getContext())
                    .setTitleText("Todos los campos son obligatorios")
                    .show();
            return;
        }

        int cantidad = Integer.parseInt(cantidadTxt);

        int id = 0;

        if(usuario != null){
            id = usuario.getId();
        }

        int result = new MySQL().registerReserva(new Reserva(
                producto.getId(),
                id,
                talla,
                cantidad,
                telefono,
                direccion
        ), fragment.getContext());

        if (result == -1) {
            new SweetAlertDialog(fragment.getContext())
                    .setTitleText("Error al realizar la reserva")
                    .show();
        } else {
            new SweetAlertDialog(fragment.getContext())
                    .setTitleText("Su reserva fue realizada satisfactoriamente")
                    .show();

            ((MainActivity) getActivity()).showReservar(false);
        }
    }

    private void cancel() {
        ((MainActivity) getActivity()).showReservar(false);
    }
}