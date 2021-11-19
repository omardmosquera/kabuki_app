package com.kabuki.kabukiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.kabuki.MySQL.MySQL;
import com.kabuki.classes.Usuario;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegisterFragment extends Fragment {

    View fragment;

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.register_layout, container, false);

        Button registerButton = fragment.findViewById(R.id.register_button);
        registerButton.setOnClickListener(v -> onRegister());
        Button cancelButton =  fragment.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(v -> onCancel());

        return fragment;
    }

    public void onRegister() {
        String nombre = ((TextInputEditText) fragment.findViewById(R.id.input_name)).getText().toString();
        String correo = ((TextInputEditText) fragment.findViewById(R.id.input_mail)).getText().toString();
        String direccion = ((TextInputEditText) fragment.findViewById(R.id.input_address)).getText().toString();
        String telefono = ((TextInputEditText) fragment.findViewById(R.id.input_phone)).getText().toString();
        String pass = ((TextInputEditText) fragment.findViewById(R.id.input_pass)).getText().toString();
        String confirmPass = ((TextInputEditText) fragment.findViewById(R.id.input_confirm_pass)).getText().toString();

        if (pass != "" && pass.equals(confirmPass)) {
            int result = new MySQL().registerUser(new Usuario(
                    nombre,
                    correo,
                    direccion,
                    telefono,
                    pass
            ), fragment.getContext());

            if (result != -1) {
                new SweetAlertDialog(fragment.getContext())
                        .setTitleText("Usuario Registrado, ingrese con sus credenciales")
                        .show();

                ((MainActivity) getActivity()).showRegister(false);
            }
        } else {
            new SweetAlertDialog(fragment.getContext())
                    .setTitleText("Las contraseñas no coinciden")
                    .show();
        }
    }

    public void onCancel(){
        ((MainActivity) getActivity()).showRegister(false);
    }
}
