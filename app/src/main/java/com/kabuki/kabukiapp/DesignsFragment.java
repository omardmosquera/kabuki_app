package com.kabuki.kabukiapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.kabuki.MySQL.MySQL;
import com.kabuki.classes.Producto;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignsFragment extends Fragment {
    public DesignsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.designs_layout, container, false);

        loadSlider(fragment);
        loadProducts(fragment);

        return fragment;
    }

    private void loadProducts(View fragment){
        LinkedList<Producto> productos = new MySQL().getProducts(fragment.getContext());
    }

    private void loadSlider(View fragment){
        int design1 = R.drawable.design_style_1;
        int design2 = R.drawable.design_style_2;
        int design3 = R.drawable.design_style_3;
        int design4 = R.drawable.design_style_4;
        int design5 = R.drawable.design_style_5;
        int design6 = R.drawable.design_style_6;
        int design7 = R.drawable.design_style_7;

        ArrayList<SliderItem> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = fragment.findViewById(R.id.imageSlider);

        sliderDataArrayList.add(new SliderItem(design1));
        sliderDataArrayList.add(new SliderItem(design2));
        sliderDataArrayList.add(new SliderItem(design3));
        sliderDataArrayList.add(new SliderItem(design4));
        sliderDataArrayList.add(new SliderItem(design5));
        sliderDataArrayList.add(new SliderItem(design6));
        sliderDataArrayList.add(new SliderItem(design7));

        SliderAdapter adapter = new SliderAdapter(fragment.getContext());

        adapter.renewItems(sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.COLOR);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);
    }
}
