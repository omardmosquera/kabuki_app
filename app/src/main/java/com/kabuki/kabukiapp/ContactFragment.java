package com.kabuki.kabukiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.contact_layout, container, false);

        ImageView wt = fragment.findViewById(R.id.whatsapp);
        wt.setOnClickListener(v -> goToWhatsapp());
        TextView wti = fragment.findViewById(R.id.whatsapp_info);
        wti.setOnClickListener(v -> goToWhatsapp());

        ImageView ig = fragment.findViewById(R.id.instagram);
        ig.setOnClickListener(v -> goToInstagram());
        TextView igi = fragment.findViewById(R.id.instagram_info);
        igi.setOnClickListener(v -> goToInstagram());

        return fragment;
    }

    public void goToInstagram() {
        String url = "https://www.instagram.com/kabukiclothing_oficial";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void goToWhatsapp() {
        String url = "https://wa.me/573028512884";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
