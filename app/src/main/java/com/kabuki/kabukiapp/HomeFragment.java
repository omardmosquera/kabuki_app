package com.kabuki.kabukiapp;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.home_layout, container, false);

        TextView textHome = fragment.findViewById(R.id.home_title);
        TextView textDescription = fragment.findViewById(R.id.home_description);
        TextView textDesign = fragment.findViewById(R.id.home_designs);

        textHome.setText(Html.fromHtml(getString(R.string.about_title)));
        textDescription.setText(Html.fromHtml(getString(R.string.about_description)));
        textDesign.setText(Html.fromHtml(getString(R.string.about_designs)));

        int foto1 = R.drawable.foto_1;
        int foto2 = R.drawable.foto_2;
        int foto3 = R.drawable.foto_3;
        int foto4 = R.drawable.foto_4;
        int foto5 = R.drawable.foto_5;

        ArrayList<SliderItem> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = fragment.findViewById(R.id.imageSlider);

        sliderDataArrayList.add(new SliderItem(foto1));
        sliderDataArrayList.add(new SliderItem(foto2));
        sliderDataArrayList.add(new SliderItem(foto3));
        sliderDataArrayList.add(new SliderItem(foto4));
        sliderDataArrayList.add(new SliderItem(foto5));

        SliderAdapter adapter = new SliderAdapter(fragment.getContext());

        adapter.renewItems(sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(4);

        return fragment;
    }
}
