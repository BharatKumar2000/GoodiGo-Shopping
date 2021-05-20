package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.main.Address;
import com.example.myapplication.main.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AccountsFragment extends Fragment {

//    private AccountsViewModel mViewModel;
    TextView accountName, accountAge, accountMail, addrPart1, addrPart2, country, state, city, pinCode;
    Address address = null;
    User user = null;

//    public static AccountsFragment newInstance() {
//        return new AccountsFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.accounts_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        accountName = view.findViewById(R.id.L1t2);
        accountAge  = view.findViewById(R.id.L2t2);
        accountMail = view.findViewById(R.id.L3t2);
        addrPart1   = view.findViewById(R.id.L4t2);
        addrPart2   = view.findViewById(R.id.L5t2);
        country     = view.findViewById(R.id.L6t2);
        state       = view.findViewById(R.id.L7t2);
        city        = view.findViewById(R.id.L8t2);
        pinCode     = view.findViewById(R.id.L9t2);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser != null) {
            FirebaseDatabase.getInstance().getReference("Users").child(currentUser.getUid()).get()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        user = Objects.requireNonNull(task.getResult()).getValue(User.class);
                        if(user !=null) {
                            accountName.setText(user.getName());
                            accountAge.setText(user.getAge());
                            accountMail.setText(user.getMail());
                        }
                        Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));
                    }
                });

            FirebaseDatabase.getInstance().getReference("Address").child(currentUser.getUid()).get()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting User Address", task.getException());
                    }
                    else {
                        address= Objects.requireNonNull(task.getResult()).getValue(Address.class);
                        if(address!=null) {
                            addrPart1.setText(address.getAddOne());
                            addrPart2.setText(address.getAddTwo());
                            country.setText(address.getCountryname());
                            state.setText(address.getStatename());
                            city.setText(address.getCityname());
                            pinCode.setText(address.getPincode());
                        }
                        Log.d("firebase user address:", String.valueOf(task.getResult().getValue()));
                    }
                });
        }
    }

}