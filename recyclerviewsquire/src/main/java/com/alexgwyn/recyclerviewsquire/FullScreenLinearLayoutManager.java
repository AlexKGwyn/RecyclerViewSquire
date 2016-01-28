package com.alexgwyn.recyclerviewsquire;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;

/**
 * {@link LinearLayoutManager} which lays out each of its views the width and height of the screen
 */
public class FullScreenLinearLayoutManager extends LinearLayoutManager {

    public FullScreenLinearLayoutManager(Context context) {
        super(context);
    }

    public FullScreenLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public FullScreenLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        measureChild(child, widthUsed, heightUsed);
    }

    @Override
    public void measureChild(View child, int widthUsed, int heightUsed) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), View.MeasureSpec.EXACTLY);
        child.measure(widthMeasureSpec, heightMeasureSpec);
    }
}
