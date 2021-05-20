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
//import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Constants;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.main.Item;
import com.example.myapplication.ui.adapters.HomeAdapter;
//import com.example.myapplication.ui.viewmodels.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private MainActivity activity;
    private GridView gridView;
    private HomeAdapter adapter;
    private TextView noItemsView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.gd1);
        noItemsView = view.findViewById(R.id.no_items);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) requireActivity();
        
        adapter = new HomeAdapter(activity, new ArrayList<>(Constants.PC_ITEMS));
        gridView.setAdapter(adapter); gridView.setTextFilterEnabled(true);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Item item = (Item) parent.getItemAtPosition(position);
            Fragment fragment = null;

            Log.d("CLICK", "Label of tapped item: " + item.getName());
            switch(item.getName()) {
                case "Monitor"     : fragment = new ComponentListFragment(Constants.Monitor_ITEMS    ); break;
                case "CPU Cabinet" : fragment = new ComponentListFragment(Constants.CPUCabinet_ITEMS ); break;
                case "Motherboard" : fragment = new ComponentListFragment(Constants.Motherboard_ITEMS); break;
                case "Graphic Card": fragment = new ComponentListFragment(Constants.GraphicCard_ITEMS); break;
                case "CD Driver"   : fragment = new ComponentListFragment(Constants.CDDriver_ITEMS   ); break;
                case "Gamepad"     : fragment = new ComponentListFragment(Constants.Gamepad_ITEMS    ); break;
                case "Processor"   : fragment = new ComponentListFragment(Constants.Processor_ITEMS  ); break;
                case "RAM"         : fragment = new ComponentListFragment(Constants.RAM_ITEMS        ); break;
                case "Hard Drive"  : fragment = new ComponentListFragment(Constants.HardDrive_ITEMS  ); break;
                case "SMPS"        : fragment = new ComponentListFragment(Constants.SMPS_ITEMS       ); break;
                case "Keyboard"    : fragment = new ComponentListFragment(Constants.Keyboard_ITEMS   ); break;
                case "Mouse"       : fragment = new ComponentListFragment(Constants.Mouse_ITEMS      ); break;
                case "Speaker"     : fragment = new ComponentListFragment(Constants.Speaker_ITEMS    ); break;
                case "Connector"   : fragment = new ComponentListFragment(Constants.Connector_ITEMS  ); break;
                case "Router"   : fragment = new ComponentListFragment(Constants.Router_ITEMS); break;
                default: Toast.makeText(activity.getApplicationContext (),"Invalid case",Toast.LENGTH_SHORT).show();
            }
            if(fragment != null) {
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment, "ITEM")
                        .addToBackStack("ITEM")
                        .commit();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.activity_main, menu);
        MenuItem menuItem = menu.findItem(R.id.sv1);
        MenuItem menuItem1=menu.findItem(R.id.cart);

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
            public boolean onQueryTextSubmit(String query) { return false; }
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