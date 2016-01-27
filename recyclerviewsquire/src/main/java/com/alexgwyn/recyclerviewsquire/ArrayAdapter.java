package com.alexgwyn.recyclerviewsquire;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ArrayAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    private ArrayList<T> mItems = new ArrayList<>();

    public T get(int position) {
        return mItems.get(position);
    }

    public void add(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size() - 1);
    }

    public void addAll(Collection<T> items) {
        int size = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(size - 1, items.size());
    }

    public void replace(Collection<T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void remove(T item) {
        int position = mItems.indexOf(item);
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = mItems.size();
        mItems.clear();
        notifyItemRangeRemoved(0, size);
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
