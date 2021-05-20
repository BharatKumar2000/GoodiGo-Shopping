package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.main.Order;
import com.example.myapplication.ui.adapters.MyorderAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyOrders extends Fragment {
    private ListView ordersList;
    MyorderAdapter adapter;
    MainActivity activity;

    public static MyOrders newInstance() {
        return new MyOrders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_orders_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ordersList = view.findViewById(R.id.my_orders_list);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) requireActivity();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            FirebaseDatabase.getInstance().getReference("PurchasedOrders").child(currentUser.getUid()).get()
            .addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    List<Order> orders = new ArrayList<>();
                    for(DataSnapshot childSnapshot : Objects.requireNonNull(task.getResult()).getChildren()) {
                        orders.add(childSnapshot.getValue(Order.class));
                    }
                    if (orders.size() > 0) {
                        adapter = new MyorderAdapter(activity, orders);
                        ordersList.setAdapter(adapter);
                    }
                    Log.d("firebase myoder data:", String.valueOf(task.getResult().getValue()));
                }
            });
        }

    }
}