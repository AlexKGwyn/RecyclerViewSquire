package com.alexgwyn.recyclerviewsquire;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class TypedViewHolder<T> extends ClickableViewHolder {


    public TypedViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(int position, T item);


}
