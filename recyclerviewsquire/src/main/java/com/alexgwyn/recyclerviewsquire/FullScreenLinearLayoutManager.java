package com.alexgwyn.recyclerviewsquire;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * {@link LinearLayoutManager} which lays out each of its views the width and height of the screen
 */
public class FullScreenLinearLayoutManager extends LinearLayoutManager {

    public FullScreenLinearLayoutManager(@NonNull Context context) {
        super(context);
    }

    public FullScreenLinearLayoutManager(@NonNull Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public FullScreenLinearLayoutManager(@NonNull Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void measureChildWithMargins(@NonNull View child, int widthUsed, int heightUsed) {
        measureChild(child, widthUsed, heightUsed);
    }

    @Override
    public void measureChild(@NonNull View child, int widthUsed, int heightUsed) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), View.MeasureSpec.EXACTLY);
        child.measure(widthMeasureSpec, heightMeasureSpec);
    }
}
