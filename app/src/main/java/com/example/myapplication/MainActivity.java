package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.main.Item;
import com.example.myapplication.main.Order;
import com.example.myapplication.main.User;
import com.example.myapplication.ui.adapters.MainAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;

    private NavigationView navigationView;
    public Order currentOrder;
    public MainAdapter.OnCartChangedListener cartChangedListener;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    private MenuItem logoutItem;

    void loadUserData() {
        // Check if user is signed in (non-null) and update UI accordingly.
        logoutItem.setVisible(false);

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null) {
            // Load the user's details.
            firebaseDatabase.getReference("Users").child(currentUser.getUid()).get()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        logoutItem.setVisible(false);
                        Log.e("Logout problem:", "Error getting data", task.getException());
                    }
                    else {
                        logoutItem.setVisible(true);
                        User userDetails = Objects.requireNonNull(task.getResult()).getValue(User.class);
                        if(userDetails != null) {
                            navigationView.getMenu().findItem(R.id.navLog).setTitle("Hello, "+userDetails.getName());
                            navigationView.getMenu().findItem(R.id.navLog).setIcon(R.drawable.ic_ac);
                            Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));

                        }
                    }
                })
                .addOnFailureListener(e -> {
                    logoutItem.setVisible(false);

                    Toast.makeText(getApplicationContext(), "There was a problem while loading user data.", Toast.LENGTH_LONG).show();
                });

            // Load the user's last saved order.
            firebaseDatabase.getReference("Saved Orders").child(currentUser.getUid()).get()
                .addOnCompleteListener(task -> {
                    Log.d("FIREBASE", "Order load task complete.");
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                        currentOrder = Order.makeNew(); // Use a newly created order.
                    }
                    else {
                        Order savedOrder = Objects.requireNonNull(task.getResult()).getValue(Order.class);
                        if (savedOrder != null) {
                            Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));
                            if(savedOrder.getItems()==null)
                                savedOrder.setItems(new ArrayList<>());
                            currentOrder = savedOrder; // Use the previously saved order.
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "No saved order.", Toast.LENGTH_LONG).show();
                            currentOrder = Order.makeNew(); // Use a newly created order.
                        }
                    }
                });
        }
        else { logoutItem.setVisible(false); }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth     = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().keepSynced(true);
        Toolbar toolbar = findViewById(R.id.toolbar); setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Log.d("FAB", "ACTION");

//            FragmentManager manager = getSupportFragmentManager();
//
//            int i = 0;
//            for(Fragment stack_fragment : manager.getFragments()) {
//                Log.d("FRAGMENT", "#"+(++i) + " : "+stack_fragment.getClass().getName());
//            }
//            Log.d("FRAGMENT", "----");
//            Log.d("FRAGMENT", "#### Back Stack Entries: "+manager.getBackStackEntryCount());
//            Log.d("FRAGMENT", "----");

//            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
//            if(currentUser != null) {
//                Log.d("FIREBASE_PURCHASED", "CURRENT USER "+currentUser.getUid());
//                firebaseDatabase.getReference().child("Purchased Orders").get()
//                .addOnCompleteListener(task -> {
//                    if(task.isSuccessful()) {
//                        for(DataSnapshot childSnapshot : Objects.requireNonNull(task.getResult()).getChildren()) {
//                            if(childSnapshot.getKey() == null) continue;
//                            Log.d("FIREBASE_PURCHASED", "USER "+childSnapshot.getKey());
//                            Order order = childSnapshot.getValue(Order.class);
//                            if(order == null) continue;
//                            DatabaseReference node = firebaseDatabase.getReference().child("PurchasedOrders")
//                                .child(childSnapshot.getKey())
//                                .child(order.getId());
//                            node.setValue(order)
//                                .addOnCompleteListener(set_task -> {
//                                    if(set_task.isSuccessful()) {
//                                        Log.d("FIREBASE_PURCHASED", "Order "+order.getId()+" ready for deletion.");
//                                        childSnapshot.getRef().removeValue()
//                                        .addOnCompleteListener(delete_task -> {
//                                            if(delete_task.isSuccessful())
//                                                Log.d("FIREBASE_PURCHASED", "Order "+order.getId()+" successfully migrated.");
//                                        });
//                                    }
//                                });
//                        }
//                    }
//                })
//                .addOnFailureListener(e -> Log.e("FIREBASE_PURCHASED", "Error", e));
//            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        mAppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                                                      .setOpenableLayout(drawer).build();

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            FragmentManager manager = getSupportFragmentManager();
            Log.d("NAVIGATION", destination.getLabel() != null ? destination.getLabel().toString() : "None");

            Fragment fragment = manager.findFragmentByTag("ITEM");
            if(fragment != null) manager.beginTransaction().remove(fragment).commit();

            if(manager.getBackStackEntryCount() > 0 && destination.getLabel().toString().equals("Home")) {
                for(int i=0; i<manager.getBackStackEntryCount(); i++) manager.popBackStack();
            }
        });

        logoutItem = navigationView.getMenu().findItem(R.id.nav7);
        logoutItem.setOnMenuItemClickListener(item -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if (logoutItem.isVisible()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Confirm Log Out");
                builder.setMessage("you are signing out of your GoodiGo Account on this device.").setCancelable(true)
                    .setPositiveButton("LOG OUT", (dialog, id) -> {
                        logoutItem.setVisible(true);
                        firebaseAuth.signOut();
                        logoutItem.setVisible(false);
                        currentOrder=Order.makeNew();
                        navigationView.getMenu().findItem(R.id.navLog).setTitle("Log in/Sign up");
                        navigationView.getMenu().findItem(R.id.navLog).setIcon(R.drawable.iclog);

                    })
                    .setNegativeButton("CANCEL", (dialog, id) -> dialog.cancel());
                AlertDialog dialog=builder.create();
                dialog.show();
            }
            return false;
        });
        navigationView.getMenu().findItem(R.id.navLog).setOnMenuItemClickListener(item -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if(currentUser==null)
                startActivity(new Intent(MainActivity.this,Login.class));
            return false;
        });

        // Create the listener to use to add items to the order.
        cartChangedListener = new MainAdapter.OnCartChangedListener() {
            @Override
            public void onAddedToCart(Item item) {
                currentOrder.addItem(item);
                Toast.makeText(MainActivity.this.getApplicationContext(), "Item added to your cart", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onRemovedFromCart(Item item) {
                currentOrder.removeItem(item);
                Toast.makeText(MainActivity.this.getApplicationContext(), "Item removed from your cart", Toast.LENGTH_LONG).show();
            }
        };

        loadUserData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent); loadUserData();
    }

    @Override public void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            logoutItem.setVisible(false);
            if(currentOrder != null) currentOrder.getItems().clear();
            else currentOrder = Order.makeNew();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}