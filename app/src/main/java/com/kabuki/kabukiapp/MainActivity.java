package com.kabuki.kabukiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(0).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_designs:
                        startActivity(new Intent(MainActivity.this, DesignsActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(MainActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });

        TextView textHome = findViewById(R.id.home_title);
        TextView textDescription = findViewById(R.id.home_description);
        TextView textDesign = findViewById(R.id.home_designs);

        textHome.setText(Html.fromHtml(getString(R.string.about_title)));
        textDescription.setText(Html.fromHtml(getString(R.string.about_description)));
        textDesign.setText(Html.fromHtml(getString(R.string.about_designs)));

        int foto1 = R.drawable.foto_1;
        int foto2 = R.drawable.foto_2;
        int foto3 = R.drawable.foto_3;
        int foto4 = R.drawable.foto_4;
        int foto5 = R.drawable.foto_5;

        ArrayList<SliderItem> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.imageSlider);

        sliderDataArrayList.add(new SliderItem(foto1));
        sliderDataArrayList.add(new SliderItem(foto2));
        sliderDataArrayList.add(new SliderItem(foto3));
        sliderDataArrayList.add(new SliderItem(foto4));
        sliderDataArrayList.add(new SliderItem(foto5));

        SliderAdapter adapter = new SliderAdapter(this);

        adapter.renewItems(sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);
    }

}