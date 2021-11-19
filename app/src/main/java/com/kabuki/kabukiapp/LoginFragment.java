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

public class LoginFragment extends Fragment {

    View fragment;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.login_layout, container, false);

        Button loginButton = (Button) fragment.findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> onLogin());

        Button loginRegister = (Button) fragment.findViewById(R.id.login_register);
        loginRegister.setOnClickListener(v -> onRegister());

        return fragment;
    }

    public void onLogin() {
        String mail = ((TextInputEditText) fragment.findViewById(R.id.input_mail)).getText().toString();
        String pass = ((TextInputEditText) fragment.findViewById(R.id.input_pass)).getText().toString();

        Usuario result = new MySQL().loginUser(new Usuario(mail.toString(), pass.toString()), fragment.getContext());

        if (result.getCorreo() != null) {
            ((MainActivity) getActivity()).loginUser(result);
        }
    }

    public void onRegister() {
        ((MainActivity) getActivity()).showRegister(true);
    }
}
