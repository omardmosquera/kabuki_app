package com.kabuki.kabukiapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.kabuki.MySQL.MySQL;
import com.kabuki.classes.Producto;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class DesignsFragment extends Fragment {
    private View fragment;
    private LinkedList<Producto> productos;

    public DesignsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.designs_layout, container, false);

        loadSlider();
        loadProducts();

        return fragment;
    }

    private void loadProducts() {
        productos = new MySQL().getProducts(fragment.getContext());

        LinearLayout productosLayout = fragment.findViewById(R.id.product_layout);

        for (Producto producto : productos) {
            LinearLayout productoLayout = new LinearLayout(fragment.getContext());
            productoLayout.setOrientation(LinearLayout.HORIZONTAL);
            productoLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            try {
                InputStream inputS = producto.getImagen().getBinaryStream();
                Bitmap imagen = BitmapFactory.decodeStream(inputS);

                ImageView productoImagen = new ImageView(fragment.getContext());
                productoImagen.setImageBitmap(imagen);

                LinearLayout.LayoutParams imageLayout = new LinearLayout.LayoutParams(350, 350);
                imageLayout.setMargins(0, 0, 20, 0);
                productoImagen.setLayoutParams(imageLayout);

                productoImagen.requestLayout();

                productoLayout.addView(productoImagen);
            } catch (SQLException sqlE) {

            }

            LinearLayout dataLayout = new LinearLayout(fragment.getContext());
            dataLayout.setOrientation(LinearLayout.VERTICAL);
            dataLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView nombre = new TextView(fragment.getContext());
            nombre.setText("Nombre: " + producto.getNombre());
            TextView descripcion = new TextView(fragment.getContext());
            descripcion.setText("Descripcion: " + producto.getDescripcion());
            TextView tallas = new TextView(fragment.getContext());
            tallas.setText("Tallas: " + producto.getTallas());

            Button reservar = new Button(fragment.getContext());
            reservar.setBackgroundColor(getResources().getColor(R.color.red));
            reservar.setTextColor(getResources().getColor(R.color.white));
            reservar.setText("Reservar");
            LinearLayout.LayoutParams reservarLayout = new LinearLayout
                    .LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            reservarLayout.setMargins(0, 10, 0, 0);
            reservar.setId(producto.getId());
            reservar.setLayoutParams(reservarLayout);
            reservar.setOnClickListener(v -> onReservar(v));

            dataLayout.addView(nombre);
            dataLayout.addView(descripcion);
            dataLayout.addView(tallas);
            dataLayout.addView(reservar);

            productoLayout.addView(dataLayout);
            productosLayout.addView(productoLayout);
        }
    }

    private void loadSlider() {
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

    private void onReservar(View v) {
        int index = -1;

        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == v.getId()){
                index = i;
                break;
            }
        }

        if (index != -1) {
            Producto productoReserva = productos.get(index);

            ((MainActivity) getActivity()).setProducto(productoReserva);
            ((MainActivity) getActivity()).showReservar(true);
        }
    }
}
