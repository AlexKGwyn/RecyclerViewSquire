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

    public int indexOf(T item) {
        return mItems.indexOf(item);
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
        if (items != null) {
            mItems.addAll(items);
        }
        notifyDataSetChanged();
    }

    public void remove(T item) {
        int position = mItems.indexOf(item);
        remove(position);
    }

    public void remove(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }


    public void clear() {
        int size = mItems.size();
        mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void insert(T item, int position) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void insertRange(Collection<T> items, int startIndex) {
        mItems.addAll(startIndex, items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public void updateItem(T oldItem, T newItem) {
        int position = mItems.indexOf(oldItem);
        if (position != -1) {
            updateItem(newItem, position);
        }
    }

    public void updateItem(T newItem, int position) {
        mItems.remove(position);
        mItems.add(position, newItem);
        notifyItemChanged(position);
    }

    /**
     * @return The backing arraylist from this adapter
     */
    public ArrayList<T> getItems() {
        return mItems;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
