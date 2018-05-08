package com.puyakul.prin.psychic_shopping;

import android.app.Service;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class ShoppingListAdapter extends ArrayAdapter<ShoppingList> {
    private int mLayoutResourceID;
    public ShoppingListAdapter(Context context, int resource, List<ShoppingList> objects){
        super(context, resource, objects);
        this.mLayoutResourceID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(mLayoutResourceID, parent, false);
        TextView textView = row.findViewById(R.id.ListView_mainListView);

        ShoppingList s = this.getItem(position);
        textView.setText(s.getId() + ": " + s.getName());
        return row;
    }
}


