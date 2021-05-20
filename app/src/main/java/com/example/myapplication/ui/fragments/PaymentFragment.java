package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.main.Order;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PaymentFragment extends Fragment {

    private MainActivity activity;
    ImageView B;
    boolean flag;
    String mode=null;
    ImageButton paypal, paycard, androidpay;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setHasOptionsMenu(true);
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.payment_fragment, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        B=view.findViewById(R.id.proceedtoshipping);
        paypal=view.findViewById(R.id.paypal);
        paycard=view.findViewById(R.id.paycard);
        androidpay=view.findViewById(R.id.androidpay);
        flag=false;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) requireActivity();

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),"Payment completed using PAYPAL",Toast.LENGTH_LONG).show();
                paycard.setEnabled(false);
                androidpay.setEnabled(false);
                mode="PAYPAL";
                flag=true;
                B.setEnabled(true);
            }
        });
        paycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),"Payment completed using PAYCARD",Toast.LENGTH_LONG).show();
                paypal.setEnabled(false);
                androidpay.setEnabled(false);
                mode="PAYCARD";
                flag=true;
                B.setEnabled(true);

            }
        });

        androidpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),"Payment completed using ANDROID PAY",Toast.LENGTH_LONG).show();
                paycard.setEnabled(false);
                paypal.setEnabled(false);
                mode="ANDROID PAY";
                B.setEnabled(true);
                flag=true;
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==false)
                {
                    Toast.makeText(activity.getApplicationContext(),"Select Payment Method",Toast.LENGTH_LONG).show();

                }
                else
                {
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    if(currentUser != null) {
                        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                        activity.currentOrder.setOrderdate(date);
                        FirebaseDatabase.getInstance().getReference("PurchasedOrders")
                            .child(currentUser.getUid())
                            .child(activity.currentOrder.getId())
                            .setValue(activity.currentOrder)
                            .addOnCompleteListener(task -> {
                                if(task.isSuccessful()) {
                                    activity.currentOrder= Order.makeNew();
                                    FirebaseDatabase.getInstance().getReference("Saved Orders").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                                            if(task.isSuccessful())
                                                Toast.makeText(getContext(), "Order Purchased.", Toast.LENGTH_LONG).show();
                                            else
                                                Toast.makeText(getContext(), "Some error occured while buying!!", Toast.LENGTH_LONG).show();

                                        }
                                    });
                                    Toast.makeText(getContext(), "DATA stored!", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getContext(), "ERROR: DATA not stored!", Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(e -> Log.e("FIREBASE ORDER:", "Some exception occurred: ", e));
                    }
                Fragment fragment=new OrderPurchasedFragment();
                    Bundle args = new Bundle();
                    args.putString("PaymentMode",mode);
                    fragment.setArguments(args);
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment, "ITEM")
                        .addToBackStack("ITEM")
                        .commit();
            }}
        });


    }


}