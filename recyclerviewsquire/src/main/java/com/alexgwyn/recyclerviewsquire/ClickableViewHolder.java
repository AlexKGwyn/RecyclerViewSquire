package com.alexgwyn.recyclerviewsquire;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class ClickableViewHolder extends RecyclerView.ViewHolder {

    private onClickListener mClickListener;
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
        mClickableView.setOnClickListener(mViewClickListener);
    }

    public void setClickListener(onClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface onClickListener {
        void onItemClick(View v, int position);
    }
}
