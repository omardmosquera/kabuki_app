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

public class ProfileFragment extends Fragment {
    private View fragment;
    private Usuario usuario;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.profile_layout, container, false);
        usuario = ((MainActivity) getActivity()).getUsuario();
        loadData();

        Button saveButton = (Button) fragment.findViewById(R.id.save_button);
        saveButton.setOnClickListener(v -> onSaveUser());

        Button logoutButton = (Button) fragment.findViewById(R.id.log_out_button);
        logoutButton.setOnClickListener(v -> onLogOut());

        return fragment;
    }

    private void onSaveUser() {
        String pass = ((TextInputEditText) fragment.findViewById(R.id.input_pass)).getText().toString();
        String confirmPass = ((TextInputEditText) fragment.findViewById(R.id.input_confirm_pass)).getText().toString();

        if (pass.equals(confirmPass)) {
            if(pass == ""){
                pass = usuario.getContrasena();
            }

            Usuario newUsuario = new Usuario(
                    usuario.getId(),
                    ((TextInputEditText) fragment.findViewById(R.id.input_name)).getText().toString(),
                    ((TextInputEditText) fragment.findViewById(R.id.input_mail)).getText().toString(),
                    ((TextInputEditText) fragment.findViewById(R.id.input_address)).getText().toString(),
                    ((TextInputEditText) fragment.findViewById(R.id.input_phone)).getText().toString(),
                    pass
            );

            int result = new MySQL().updateUser(newUsuario, fragment.getContext());

            if (result != -1) {
                this.usuario = newUsuario;
                loadData();
                ((MainActivity) getActivity()).loginUser(newUsuario);

                new SweetAlertDialog(fragment.getContext())
                        .setTitleText("Usuario Actualizado!!")
                        .show();
            }
        } else {
            new SweetAlertDialog(fragment.getContext())
                    .setTitleText("Las contraseñas no coinciden")
                    .show();
        }
    }

    private void loadData() {
        TextInputEditText nombre = (TextInputEditText) fragment.findViewById(R.id.input_name);
        TextInputEditText correo = (TextInputEditText) fragment.findViewById(R.id.input_mail);
        TextInputEditText direccion = (TextInputEditText) fragment.findViewById(R.id.input_address);
        TextInputEditText telefono = (TextInputEditText) fragment.findViewById(R.id.input_phone);

        nombre.setText(usuario.getNombre());
        correo.setText(usuario.getCorreo());
        direccion.setText(usuario.getDireccion());
        telefono.setText(usuario.getTelefono());
    }

    private void onLogOut(){
        ((MainActivity) getActivity()).logOut();
    }
}