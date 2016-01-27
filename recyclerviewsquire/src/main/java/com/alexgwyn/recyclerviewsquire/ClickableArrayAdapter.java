package com.alexgwyn.recyclerviewsquire;

import android.support.annotation.CallSuper;
import android.view.View;


public abstract class ClickableArrayAdapter<T, V extends ClickableViewHolder> extends ArrayAdapter<T, V> {

    private onItemClickListener<T> mItemClickListener;
    private TypedViewHolder.onClickListener mClickListener = new TypedViewHolder.onClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClicked(v, position, get(position));
            }
        }
    };

    @Override
    @CallSuper
    public void onBindViewHolder(V holder, int position) {
        holder.setClickListener(mClickListener);
    }

    public void setOnItemClickListener(onItemClickListener<T> itemClickListener) {
        mItemClickListener = itemClickListener;

    }


    public interface onItemClickListener<T> {
        void onItemClicked(View view, int position, T item);
    }
}
