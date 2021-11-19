package com.kabuki.kabukiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kabuki.MySQL.MySQL;
import com.kabuki.classes.Producto;
import com.kabuki.classes.Usuario;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private Usuario usuario;
    private Boolean isUserLogin = false;
    private Boolean showRegister = false;
    private Boolean showReservar = false;
    private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.menu_layout);

        configBottomNavBar();
    }

    private void configBottomNavBar() {
        bnv = findViewById(R.id.navigation_bottom);

        bnv.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home:
                    item.setChecked(true);
                    showFragment(new HomeFragment());
                    break;
                case R.id.action_designs:
                    item.setChecked(true);

                    if (showReservar) {
                        showFragment(new ReserveFragment());
                    } else {
                        showFragment(new DesignsFragment());
                    }
                    break;
                case R.id.action_contact:
                    item.setChecked(true);
                    showFragment(new ContactFragment());
                    break;
                case R.id.action_profile:
                    item.setChecked(true);

                    if (isUserLogin) {
                        showFragment(new ProfileFragment());
                    } else {
                        if (showRegister) {
                            showFragment(new RegisterFragment());
                        } else {
                            showFragment(new LoginFragment());
                        }
                    }
                    break;
            }

            return false;
        });

        bnv.setSelectedItemId(R.id.action_home);
    }

    private void showFragment(Fragment frg) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.body_app, frg)
                .commit();
    }

    public void showRegister(boolean show) {
        this.showRegister = show;
        bnv.setSelectedItemId(R.id.action_profile);
    }

    public void showReservar(boolean show) {
        this.showReservar = show;
        bnv.setSelectedItemId(R.id.action_designs);
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void loginUser(Usuario usuario) {
        this.usuario = usuario;
        this.isUserLogin = true;
        bnv.setSelectedItemId(R.id.action_profile);
    }

    public void logOut() {
        this.usuario = null;
        this.isUserLogin = false;
        bnv.setSelectedItemId(R.id.action_profile);
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}