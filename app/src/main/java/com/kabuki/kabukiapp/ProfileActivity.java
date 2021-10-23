package com.kabuki.kabukiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(3).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(ProfileActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(ProfileActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    public void requestLogin(View view){
        setContentView(R.layout.profile_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(3).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(ProfileActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(ProfileActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    public void requestProfile(View view){
        setContentView(R.layout.profile_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(3).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(ProfileActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(ProfileActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    public void requestRegister(View view){
        setContentView(R.layout.register_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(3).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(ProfileActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(ProfileActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }
}
