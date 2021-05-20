package com.example.myapplication.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.main.Item;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private LayoutInflater inflater;
    private final List<Item> items;
    private final List<Item> allItems;
    // Layout resource ID to use while inflating views.
    private int itemLayoutId = R.layout.row_item;

    public HomeAdapter(Context c, List<Item> items) {
        super(c, R.layout.row_item, items);
        this.items = items; this.allItems = new ArrayList<>(items);
        this.context = c;
    }
    public HomeAdapter(Context c, int itemLayoutId, List<Item> items) {
        super(c, itemLayoutId, items);
        this.itemLayoutId = itemLayoutId;
        this.items = items; this.allItems = new ArrayList<>(items);
        this.context = c;
    }
    @Override
    public int getCount() { return items.size(); }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) { return items.get(position).getResourceId(); }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null) inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) convertView = inflater.inflate(itemLayoutId,null);

        ImageView imageView = convertView.findViewById(R.id.ivg);
        TextView  textView  = convertView.findViewById(R.id.tvg);
        TextView  textView1 = convertView.findViewById(R.id.tvg2);
        TextView  textView2 = convertView.findViewById(R.id.tvg3);

        imageView.setImageResource(items.get(position).getResourceId());
        textView.setText(items.get(position).getName());
        if(textView1!=null && items.get(position).getPrice()!=null)
            textView1.setText(items.get(position).getPrice());
        if(textView2!=null && items.get(position).getRating()!=null)
            textView2.setText(items.get(position).getRating());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString().toLowerCase();
                FilterResults result = new FilterResults();

                List<Item> values;
                if(!query.isEmpty()) {
                    values = new ArrayList<>();
                    for(Item item : allItems) {
                        if(item.getName().toLowerCase().contains(query))
                            values.add(item);
                    }
                }
                else values = allItems;

                result.values = values;
                result.count = values.size();
                return result;
            }

            @Override
            @SuppressWarnings("unchecked")
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                HomeAdapter.this.notifyDataSetChanged();
                HomeAdapter.this.clear();
                HomeAdapter.this.addAll((ArrayList<Item>) filterResults.values);
                HomeAdapter.this.notifyDataSetInvalidated();
            }
        };
    }
}
