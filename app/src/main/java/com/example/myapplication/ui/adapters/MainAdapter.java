package com.example.myapplication.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.main.Item;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private LayoutInflater inflater;
    private final List<Item> items;
    private final List<Item> allItems;
    // Layout resource ID to use while inflating views.
    private int itemLayoutId = R.layout.row_item;

    public interface OnCartChangedListener {
        void onAddedToCart(Item item);
        void onRemovedFromCart(Item item);
    }

    private OnCartChangedListener listener = null;

    public MainAdapter(Context c, List<Item> items) {
        super(c, R.layout.row_item, items);
        this.items = items; this.allItems = new ArrayList<>(items);
        this.context = c;
    }
    public MainAdapter(Context c, int itemLayoutId, List<Item> items) {
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

        ImageView imageView        = convertView.findViewById(R.id.ivg);
        TextView textView          = convertView.findViewById(R.id.tvg);
        TextView textView1         = convertView.findViewById(R.id.tvg2);
        TextView textView2         = convertView.findViewById(R.id.tvg3);
        ImageButton addCartButton    = convertView.findViewById(R.id.addtocart);
        ImageButton removeCartButton = convertView.findViewById(R.id.removefromcart);

        final Item item = items.get(position);

        if(addCartButton != null)
            addCartButton.setOnClickListener(v -> {
//                MainAdapter.this.add(item);
//                if(!items.contains(item)) { allItems.add(item); items.add(item); notifyDataSetInvalidated(); }
                if(listener != null) listener.onAddedToCart(item);
            });
        if(removeCartButton != null)
            removeCartButton.setOnClickListener(v -> {
//                MainAdapter.this.remove(item);
//                if(items.contains(item)) { allItems.remove(item); items.remove(item); notifyDataSetInvalidated(); }
                if(listener != null) listener.onRemovedFromCart(item);
            });

        imageView.setImageResource(item.getResourceId());
        textView.setText(item.getName());
        if(textView1!=null && item.getPrice()!=null) textView1.setText(item.getPrice());
        if(textView2!=null && item.getRating()!=null) textView2.setText(item.getRating());
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
                MainAdapter.this.notifyDataSetChanged();
                MainAdapter.this.clear();
                MainAdapter.this.addAll((ArrayList<Item>) filterResults.values);
                MainAdapter.this.notifyDataSetInvalidated();
            }
        };
    }

    public void addOnCartChangedListener(OnCartChangedListener listener) {
        this.listener = listener;
    }
}
