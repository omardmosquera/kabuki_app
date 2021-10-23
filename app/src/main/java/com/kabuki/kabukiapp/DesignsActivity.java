package com.kabuki.kabukiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class DesignsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.designs_layout);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.navigation_bottom);

        Menu menu = bnv.getMenu();
        menu.getItem(1).setChecked(true);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(DesignsActivity.this, MainActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_contact:
                        startActivity(new Intent(DesignsActivity.this, ContactActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(DesignsActivity.this, ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });

        int design1 = R.drawable.design_style_1;
        int design2 = R.drawable.design_style_2;
        int design3 = R.drawable.design_style_3;
        int design4 = R.drawable.design_style_4;
        int design5 = R.drawable.design_style_5;
        int design6 = R.drawable.design_style_6;
        int design7 = R.drawable.design_style_7;

        ArrayList<SliderItem> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.imageSlider);

        sliderDataArrayList.add(new SliderItem(design1));
        sliderDataArrayList.add(new SliderItem(design2));
        sliderDataArrayList.add(new SliderItem(design3));
        sliderDataArrayList.add(new SliderItem(design4));
        sliderDataArrayList.add(new SliderItem(design5));
        sliderDataArrayList.add(new SliderItem(design6));
        sliderDataArrayList.add(new SliderItem(design7));

        SliderAdapter adapter = new SliderAdapter(this);

        adapter.renewItems(sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.COLOR);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);
    }

    public void requestDesign(View view){
        startActivity(new Intent(DesignsActivity.this, FormContactActivity.class));
        overridePendingTransition(0, 0);
    }
}
