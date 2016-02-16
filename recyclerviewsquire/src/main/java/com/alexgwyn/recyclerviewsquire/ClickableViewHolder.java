package com.alexgwyn.recyclerviewsquire;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * A {@link android.support.v7.widget.RecyclerView.ViewHolder} which is clickable by default.
 */
public abstract class ClickableViewHolder extends RecyclerView.ViewHolder {

    private OnClickListener mClickListener;
    private View.OnClickListener mViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    };
    private View mClickableView;
    private View mItemView;

    public ClickableViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        if (mClickableView == null) {
            setClickableView(itemView);
        }
    }

    protected Context getContext() {
        return mItemView.getContext();
    }

    public View getItemView() {
        return mItemView;
    }

    public View getClickableView() {
        return mClickableView;
    }

    protected void setClickableView(View view) {
        if (mClickableView != null) {
            mClickableView.setOnClickListener(null);
        }

        mClickableView = view;
        if (mClickableView != null) {
            mClickableView.setOnClickListener(mViewClickListener);
        }
    }

    public void setClickListener(OnClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface OnClickListener {
        void onItemClick(View v, int position);
    }
}
