package com.example.myapplication.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.adapters.MainAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderPurchasedFragment extends Fragment {

    ImageView[] stages;
    ProgressBar progress;
    CountDownTimer timer;
    TextView orderIdView;
    TextView orderdate;
    TextView payment;
    Button B;

    private ListView purchasedItemListView;
    private MainActivity activity;

    void resetStages() {
        for(ImageView stage : stages) stage.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.order_purchased_fragment, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progress =view.findViewById(R.id.progress);
        String payMode = requireArguments().getString("PaymentMode");
        purchasedItemListView = view.findViewById(R.id.purchased_order_item_list);
        orderdate=view.findViewById(R.id.realdate);
        orderIdView =view.findViewById(R.id.realid);
        payment=view.findViewById(R.id.paymentmode);
        payment.setText(payMode);
        stages = new ImageView[] {
            view.findViewById(R.id.icon_stage_1), view.findViewById(R.id.icon_stage_2),
            view.findViewById(R.id.icon_stage_3), view.findViewById(R.id.icon_stage_4),
            view.findViewById(R.id.icon_stage_5)
        };
        B=view.findViewById(R.id.bttrack);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) requireActivity();

//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if(currentUser != null) {
//            FirebaseDatabase.getInstance().getReference("PurchasedOrders")
//                .child(currentUser.getUid()).child("CURRENT").get()
//                .addOnCompleteListener(task -> {
//                    if (!task.isSuccessful()) {
//                        Log.e("firebase", "Error getting data", task.getException());
//                    }
//                    else {
//                        Order purchasedOrder = Objects.requireNonNull(task.getResult()).getValue(Order.class);
//                        if(purchasedOrder!=null) {
//                            MainAdapter adapter = new MainAdapter(activity, R.layout.mod_item_order, purchasedOrder.getItems());
//                            orderIdView.setText(purchasedOrder.getId());
//                            gridView.setAdapter(adapter);
//                            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//                            orderdate.setText(date);
//                        }
//                        Log.d("firebase user data:", String.valueOf(task.getResult().getValue()));
//                    }
//                });
//        }

        MainAdapter adapter = new MainAdapter(activity, R.layout.mod_item_order, activity.currentOrder.getItems());
        orderIdView.setText(activity.currentOrder.getId());
        purchasedItemListView.setAdapter(adapter);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        orderdate.setText(date);

        resetStages(); progress.setProgress(0);
        if(timer != null) timer.cancel();
        timer = new CountDownTimer(5 * 5000, 5 * 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress.setProgress(progress.getProgress() + 1);
                if(progress.getProgress() >= 0) stages[0].setVisibility(View.VISIBLE);
                if(progress.getProgress() >= (25 - 1)) stages[1].setVisibility(View.VISIBLE);
                if(progress.getProgress() >= (50 - 1)) stages[2].setVisibility(View.VISIBLE);
                if(progress.getProgress() >= (75 - 1)) stages[3].setVisibility(View.VISIBLE);
            }
            @Override
            public void onFinish() {
                stages[4].setVisibility(View.VISIBLE);
            }
        };
        timer.start();

        if(B!=null)
            B.setOnClickListener(v -> {
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
    }

}