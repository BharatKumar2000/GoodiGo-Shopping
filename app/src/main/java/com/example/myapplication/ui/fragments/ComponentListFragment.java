package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.main.Item;
import com.example.myapplication.ui.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class ComponentListFragment extends Fragment {
    GridView gridView;
    TextView noItemsView;

    MainAdapter adapter;
    MainActivity activity;

    private final List<Item> listItems;

    public ComponentListFragment(List<Item> listItems) {
        this.listItems = new ArrayList<>(listItems);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setHasOptionsMenu(true);
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_componentlist, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.order_item_list);
        noItemsView = view.findViewById(R.id.no_items);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        activity = (MainActivity) requireActivity();

        adapter  = new MainAdapter(activity, R.layout.mod_row, listItems);
        adapter.addOnCartChangedListener(activity.cartChangedListener);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater); menu.clear();
        inflater.inflate(R.menu.activity_main, menu);

        MenuItem menuItem  = menu.findItem(R.id.sv1);
        MenuItem menuItem1 = menu.findItem(R.id.cart);

        menuItem1.setOnMenuItemClickListener(item -> {
            Fragment fragment = new OrderCartFragment();
            if(activity.currentOrder != null) {
                activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment, "ITEM")
                    .addToBackStack("ITEM")
                    .commit();
            }
            else {
                Toast.makeText(activity.getApplicationContext(),
                    activity.getText(R.string.request_error),
                    Toast.LENGTH_LONG).show();
            }
            return false;
        });

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText, i -> {
                    Log.d("FILTER", "Size of array adapter's data: " + adapter.getCount());
                    noItemsView.setVisibility(adapter.getCount() > 0 ? View.INVISIBLE : View.VISIBLE);
                });
                return false;
            }
        });
    }
}
