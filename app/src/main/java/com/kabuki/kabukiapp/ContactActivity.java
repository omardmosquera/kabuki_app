package com.kabuki.kabukiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.contact_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(2).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(ContactActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(ContactActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(ContactActivity.this, ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }

    public void goToInstagram (View view) {
        String url = "https://www.instagram.com/kabukiclothing_oficial";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void goToWhatsapp (View view) {
        String url = "https://wa.me/573028512884";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
