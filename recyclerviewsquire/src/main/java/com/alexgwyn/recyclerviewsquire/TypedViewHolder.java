package com.alexgwyn.recyclerviewsquire;

import android.view.View;


/**
 * View holder which is associated with a model type
 * @param <T> the type
 */
public abstract class TypedViewHolder<T> extends ClickableViewHolder {


    public TypedViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(int position, T item);


}
