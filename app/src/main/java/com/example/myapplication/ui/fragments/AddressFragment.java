package com.example.myapplication.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Login;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.SignIn;
import com.example.myapplication.main.Address;
import com.example.myapplication.main.Item;
import com.example.myapplication.main.Order;
import com.example.myapplication.main.User;
import com.example.myapplication.ui.adapters.MainAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class AddressFragment extends Fragment {
    private MainActivity activity;
    private EditText rname, addOne, addTwo, countryname, statename, cityname, pincodeD;
    private ProgressBar pg;
    Button B;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.address_fragment, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        B = view.findViewById(R.id.proceedtopay);
        pg = view.findViewById(R.id.pg);
        rname = view.findViewById(R.id.recipientname);
        addOne = view.findViewById(R.id.addlineone);
        addTwo = view.findViewById(R.id.addlinetwo);
        countryname = view.findViewById(R.id.country);
        statename = view.findViewById(R.id.State);
        cityname = view.findViewById(R.id.city);
        pincodeD = view.findViewById(R.id.pincode);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) requireActivity();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            FirebaseDatabase.getInstance().getReference("Address").child(currentUser.getUid()).get()
                    .addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting user address", task.getException());
                            } else {
                                Address add = null;
                                add = task.getResult().getValue(Address.class);
                                if (add != null) {
                                    rname.setText(add.getRname());
                                    addOne.setText(add.getAddOne());
                                    addTwo.setText(add.getAddTwo());
                                    countryname.setText(add.getCountryname());
                                    statename.setText(add.getStatename());
                                    cityname.setText(add.getCityname());
                                    pincodeD.setText(add.getPincode());
                                }
                                Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));
                            }
                        }
                    });

            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String reciName = rname.getText().toString();
                    String addressLine1 = addOne.getText().toString();
                    String addressLine2 = addTwo.getText().toString();
                    String country = countryname.getText().toString();
                    String state = statename.getText().toString();
                    String city = cityname.getText().toString();
                    String pincode = pincodeD.getText().toString();
                    if (reciName.isEmpty()) {
                        rname.setError("Mandatory");
                        rname.requestFocus();
                    } else if (addressLine1.isEmpty()) {
                        addOne.setError("Mandatory");
                        addOne.requestFocus();
                    } else if (addressLine2.isEmpty()) {
                        addTwo.setError("Mandatory");
                        addTwo.requestFocus();
                    } else if (country.isEmpty()) {
                        countryname.setError("Mandatory");
                        countryname.requestFocus();
                    } else if (state.isEmpty()) {
                        statename.setError("Mandatory");
                        statename.requestFocus();
                    } else if (city.isEmpty()) {
                        cityname.setError("Mandatory");
                        cityname.requestFocus();
                    } else if (pincode.isEmpty()) {
                        pincodeD.setError("Mandatory");
                        pincodeD.requestFocus();
                    } else {
                        pg.setVisibility(View.VISIBLE);
                        if (currentUser != null) {
                            FirebaseDatabase.getInstance().getReference("Address").child(currentUser.getUid()).get()
                                    .addOnCompleteListener(task -> {
                                        if (!task.isSuccessful()) {
                                            Log.e("firebase", "Error getting user address", task.getException());
                                        } else {
                                            Address address = Objects.requireNonNull(task.getResult()).getValue(Address.class);
                                            if (address != null) {

                                            }
                                            Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));
                                        }
                                    });
                            Address address = new Address(reciName, addressLine1, addressLine2, country, state, city, pincode);
                            FirebaseDatabase.getInstance().getReference("Address").child(currentUser.getUid())
                                    .setValue(address)
                                    .addOnCompleteListener(task -> {
                                        if (task.isSuccessful()) {
                                            pg.setVisibility(View.INVISIBLE);
                                            Toast.makeText(getContext(), "Address stored!", Toast.LENGTH_LONG).show();
                                            Fragment fragment = new PaymentFragment();
                                            activity.getSupportFragmentManager()
                                                    .beginTransaction()
                                                    .replace(R.id.nav_host_fragment, fragment, "ITEM")
                                                    .addToBackStack("ITEM")
                                                    .commit();
                                        } else {
                                            Toast.makeText(getContext(), "ERROR: DATA  not stored!", Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .addOnFailureListener(e -> Log.e("FIREBASE Address:", "Some exception occurred: ", e));
                        } else {
                            Toast.makeText(activity.getApplicationContext(), "Please Login first!", Toast.LENGTH_LONG).show();

                        }
                    }
                }
            });


        }


    }
}