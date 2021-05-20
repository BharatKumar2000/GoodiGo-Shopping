package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.main.Item;
import com.example.myapplication.ui.adapters.MainAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import static android.view.View.INVISIBLE;

public class OrderCartFragment extends Fragment {
    private MainActivity activity;

    private TextView noItemsView;
    private ListView itemListView;
    private TextView orderCart;
    private Button save, buy;

    private MainAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setHasOptionsMenu(true);
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_order_cart, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemListView = view.findViewById(R.id.order_item_list);
        orderCart    = view.findViewById(R.id.itemcart);
        noItemsView  = view.findViewById(R.id.no_items_in_cart);
        buy          = view.findViewById(R.id.proceedtoBuy);
        save         = view.findViewById(R.id.saveforlater);
    }

    void hideCartOnEmptyOrder() {
        if(adapter != null) {
            noItemsView.setVisibility(adapter.getCount() > 0 ? INVISIBLE : View.VISIBLE  );
            orderCart  .setVisibility(adapter.getCount() > 0 ? View.VISIBLE   : INVISIBLE);
            buy        .setVisibility(adapter.getCount() > 0 ? View.VISIBLE   : INVISIBLE);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (MainActivity) requireActivity();
        adapter = new MainAdapter(activity, R.layout.row_item_order, activity.currentOrder.getItems());

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser==null)
        {
            save.setVisibility(INVISIBLE);

        }
        buy.setOnClickListener(v -> {
            if(currentUser != null) {
                Fragment fragment=new AddressFragment();
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment, "ITEM")
                        .addToBackStack("ITEM")
                        .commit();
            }
            else {
                Toast.makeText(activity.getApplicationContext(), "Please Login first!", Toast.LENGTH_LONG).show();
            }
        });
        save.setOnClickListener(v -> {
            if(currentUser != null) {
                FirebaseDatabase.getInstance().getReference("Saved Orders").child(currentUser.getUid())
                    .setValue(activity.currentOrder)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()) {
                            Toast.makeText(getContext(), "DATA stored!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getContext(), "ERROR: DATA not stored!", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(e -> Log.e("FIREBASE ORDER:", "Some exception occurred: ", e));
            }
            else
            {
                Toast.makeText(activity.getApplicationContext(), "Please Login first!", Toast.LENGTH_LONG).show();

            }
        });

        hideCartOnEmptyOrder();

        adapter.addOnCartChangedListener(new MainAdapter.OnCartChangedListener() {
            @Override public void onAddedToCart(Item item) { }
            @Override public void onRemovedFromCart(Item item) {
                activity.currentOrder.removeItem(item); adapter.notifyDataSetChanged();
                Toast.makeText(activity.getApplicationContext(), "Item removed from your cart", Toast.LENGTH_LONG).show();
                hideCartOnEmptyOrder();
            }
        });
        itemListView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater); menu.clear();
    }

}
