package com.alexgwyn.recyclerviewsquire;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@link android.support.v7.widget.RecyclerView.Adapter} which works more like {@link android.widget.ArrayAdapter}
 *
 * @param <T> the type
 * @param <V> the viewHolder
 */
public abstract class ArrayAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    private ArrayList<T> mItems = new ArrayList<>();

    public T get(int position) {
        return mItems.get(position);
    }

    public void add(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size());
    }

    public void addAll(Collection<T> items) {
        int size = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(size, items.size());
    }

    /**
     * Use {@link #clearAndFill(Collection)}
     */
    @Deprecated
    public void replace(Collection<T> items) {
        clearAndFill(items);
    }

    public void clearAndFill(Collection<T> items) {
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
