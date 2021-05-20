package com.example.myapplication.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.main.Item;
import com.example.myapplication.main.Order;

import java.util.List;

public class MyorderAdapter extends ArrayAdapter<Order> {
    private final Context context;
    private LayoutInflater inflater;
    private final List<Order> order;

    // Layout resource ID to use while inflating views.
    private int itemLayoutId = R.layout.myorderrow;


    public MyorderAdapter(Context c, List<Order> order) {
        super(c, R.layout.myorderrow, order);
        this.order = order; this.context = c;
    }

    public MyorderAdapter(Context c, int itemLayoutId, List<Order> order) {
        super(c, itemLayoutId, order);
        this.itemLayoutId = itemLayoutId;
        this.order = order; this.context = c;
    }

    @Override
    public int getCount() {
        return order.size();
    }

    @Override
    public Order getItem(int position) {
        return order.get(position);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(itemLayoutId, null);

        ImageView imageView        = convertView.findViewById(R.id.Myorderivg);
        TextView textView          = convertView.findViewById(R.id.Myorder1);
        TextView textView1         = convertView.findViewById(R.id.Myorder2);
        TextView textView2         = convertView.findViewById(R.id.Myorder3);

        Order currentOrder = order.get(position);
        Item firstItem = currentOrder.getItems().get(0);

        imageView.setImageResource(firstItem.getResourceId());
        if(currentOrder.getItems().size()>1)
        textView.setText(firstItem.getName() +"+" +currentOrder.getItems().size() +"more");
        else
            textView.setText(firstItem.getName());

        textView1.setText(currentOrder.getId());
        textView2.setText(currentOrder.getOrderdate());

        return convertView;
    }
}