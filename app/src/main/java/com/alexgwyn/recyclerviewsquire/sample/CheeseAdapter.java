package com.alexgwyn.recyclerviewsquire.sample;

import android.view.ViewGroup;

import com.alexgwyn.recyclerviewsquire.ClickableArrayAdapter;

/**
 * Adapter for the recyclerview, which holds cheeses
 */
public class CheeseAdapter extends ClickableArrayAdapter<Cheese, CheeseViewHolder> {

    @Override
    public CheeseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CheeseViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(CheeseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.bind(position, get(position));
    }
}
