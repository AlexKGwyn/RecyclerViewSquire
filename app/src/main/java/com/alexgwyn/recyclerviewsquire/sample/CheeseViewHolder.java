package com.alexgwyn.recyclerviewsquire.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexgwyn.recyclerviewsquire.TypedViewHolder;

/**
 * The view holder related to each Cheese item
 */
public class CheeseViewHolder extends TypedViewHolder<Cheese> {

    public static CheeseViewHolder newInstance(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cheese, parent, false);
        return new CheeseViewHolder(view);
    }

    public ImageView image;
    public TextView title;

    public CheeseViewHolder(View view) {
        super(view);
        image = (ImageView) view.findViewById(R.id.image);
        title = (TextView) view.findViewById(R.id.name);
    }

    @Override
    public void bind(int position, Cheese item) {
        image.setImageResource(item.getDrawable());
        title.setText(item.getName());
    }
}
