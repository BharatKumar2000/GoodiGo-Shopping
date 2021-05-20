package com.example.myapplication.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class CustomerServiceFragment extends Fragment {
    private LinearLayout loc,mail,call;
    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loc=view.findViewById(R.id.locationdetails);
        mail=view.findViewById(R.id.maildetails);
        call=view.findViewById(R.id.calldetails);

    }
        @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            activity = (MainActivity) requireActivity();

            loc.setOnClickListener(v -> {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=B-23+Yadav nagar+samaypur badli+delhi");
                Log.d("FIREBASE", "Uri: "+gmmIntentUri);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(activity.getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                else {
                    Toast.makeText(activity.getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            });

       mail.setOnClickListener(v -> {
           Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
           email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "alcatron.vj.xxx@gmail.com" });
           if (email.resolveActivity(activity.getPackageManager()) != null) {
               startActivity(email);
           }
           else {
               Toast.makeText(
                   activity.getApplicationContext(),
                   "No app to send email. Please install at least one",
                   Toast.LENGTH_SHORT
               ).show();
           }
       });

       call.setOnClickListener(v -> {
           String phone = "8447878318";
           Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
           startActivity(intent);
       });
    }

}