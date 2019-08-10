package com.alexgwyn.recyclerviewsquire;


import java.util.ArrayList;
import java.util.Collection;

import androidx.recyclerview.widget.RecyclerView;

/**
 * {@link RecyclerView.Adapter} which works more like {@link android.widget.ArrayAdapter}
 *
 * @param <T> the type
 * @param <V> the viewHolder
 */
public abstract class ArrayAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    private ArrayList<T> mItems = new ArrayList<>();

    public T get(int position) {
        return mItems.get(position);
    }

    public T getOrNull(int position) {
        if (position >= 0 && position < getItemCount()) {
            return get(position);
        }
        return null;
    }

    public int indexOf(T item) {
        return mItems.indexOf(item);
    }

    public void add(T item) {
        add(item, true);
    }

    public void add(T item, boolean notify) {
        mItems.add(item);
        if (notify) {
            notifyItemInserted(mItems.size());
        }
    }

    public void addAll(Collection<T> items) {
        addAll(items, true);
    }

    public void addAll(Collection<T> items, boolean notify) {
        int size = mItems.size();
        mItems.addAll(items);
        if (notify) {
            notifyItemRangeInserted(size, items.size());
        }
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
        remove(item, true);
    }

    public void remove(T item, boolean notify) {
        int position = mItems.indexOf(item);
        remove(position, notify);
    }

    public void remove(int position) {
        remove(position, true);
    }

    public void remove(int position, boolean notify) {
        mItems.remove(position);
        if (notify) {
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        clear(true);
    }

    public void clear(boolean notify) {
        int size = mItems.size();
        mItems.clear();
        if (notify) {
            notifyItemRangeRemoved(0, size);
        }
    }

    public void insert(T item, int position) {
        insert(item, position, true);
    }

    public void insert(T item, int position, boolean notify) {
        mItems.add(position, item);
        if (notify) {
            notifyItemInserted(position);
        }
    }

    public void insertRange(Collection<T> items, int startIndex, boolean notify) {
        mItems.addAll(startIndex, items);
        if (notify) {
            notifyItemRangeInserted(startIndex, items.size());
        }
    }

    public void updateItem(T oldItem, T newItem) {
        updateItem(oldItem, newItem, true);
    }

    public void updateItem(T oldItem, T newItem, boolean notify) {
        int position = mItems.indexOf(oldItem);
        if (position != -1) {
            updateItem(newItem, position, notify);
        }
    }

    public void updateItem(T newItem, int position) {
        updateItem(newItem, position, true);
    }

    public void updateItem(T newItem, int position, boolean notify) {
        mItems.remove(position);
        mItems.add(position, newItem);
        if (notify) {
            notifyItemChanged(position);
        }
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
