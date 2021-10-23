package com.kabuki.kabukiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FormContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.contact_form);
    }
}
