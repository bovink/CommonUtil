package com.example.bovink.shapebackgroundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by bovink on 2016/5/3.
 */
public class GradientDrawableTextView extends TextView {

    /**
     * 如果没有设置背景且改变了background的属性，则将background设为背景
     */
    private GradientDrawable gradient = new GradientDrawable();
    /**
     * background的状态
     */
    private GradientDrawableState gradientState = new GradientDrawableState();


    public GradientDrawableTextView(Context context) {
        super(context);
    }

    public GradientDrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientDrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.GradientDrawableTextView, defStyleAttr, 0);


        updateGradientCorners(a);

        updateGradientStroke(a);

        updateGradientSolid(a);

        updateGradient();

        a.recycle();

    }

    private void updateGradientCorners(TypedArray a) {

        final int radius = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_cornerRadius, (int) gradientState.radius);
        gradient.setCornerRadius(radius);

        final int topLeftRadius = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_cornerTopLeftRadius, radius);
        final int topRightRadius = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_cornerTopRightRadius, radius);
        final int bottomLeftRadius = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_cornerBottomLeftRadius, radius);
        final int bottomRightRadius = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_cornerBottomRightRadius, radius);

        if (topLeftRadius != radius || topRightRadius != radius ||
                bottomLeftRadius != radius || bottomRightRadius != radius) {
            gradient.setCornerRadii(new float[]{
                    topLeftRadius, topLeftRadius,
                    topRightRadius, topRightRadius,
                    bottomRightRadius, bottomRightRadius,
                    bottomLeftRadius, bottomLeftRadius});

        }
    }

    private void updateGradientStroke(TypedArray a) {
        final int defaultStrokeWidth = Math.max(0, gradientState.strokeWidth);
        final int strokeWidth = a.getDimensionPixelSize(
                R.styleable.GradientDrawableTextView_gdtv_strokeWidth, defaultStrokeWidth);
        final float dashWidth = a.getDimension(
                R.styleable.GradientDrawableTextView_gdtv_strokeDashWidth, gradientState.dashWidth);

        final int strokeColor = a.getColor(
                R.styleable.GradientDrawableTextView_gdtv_strokeColor, Color.TRANSPARENT);

        if (dashWidth != 0.0f) {
            final float dashGap = a.getDimension(
                    R.styleable.GradientDrawableTextView_gdtv_strokeDashGap, gradientState.dashGap);
            gradient.setStroke(strokeWidth, strokeColor, dashWidth, dashGap);
        } else {
            gradient.setStroke(strokeWidth, strokeColor);
        }
    }

    private void updateGradientSolid(TypedArray a) {
        final int solidColor = a.getColor(
                R.styleable.GradientDrawableTextView_gdtv_solidColor, Color.TRANSPARENT);
        gradient.setColor(solidColor);
    }

    private void updateGradient() {
        if (getBackground() == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                setBackground(gradient);
            } else {
                setBackgroundDrawable(gradient);
            }
        }
    }

    public void setGradientSolidColor(String solidColor) {
        gradient.setColor(Color.parseColor(solidColor));
    }

    public void setGradientStroke(int strokeWidth, String strokeColor) {
        gradient.setStroke(strokeWidth, Color.parseColor(strokeColor));
    }

    public void setGradientStroke(int strokeWidth, String strokeColor,
                                  float strokeDashWidth, float strokeDashGap) {
        gradient.setStroke(strokeWidth, Color.parseColor(strokeColor), strokeDashWidth, strokeDashGap);
    }

    public void setGradientCornerRadius(float radius) {
        gradient.setCornerRadius(radius);
    }

    public void setGradientCornerRadii(float[] radii) {
        gradient.setCornerRadii(radii);
    }

    public void setGradient() {
        updateGradient();
    }

    /**
     * GradientDrawable状态
     */
    private class GradientDrawableState {
        public float radius = 0.0f;
        public int strokeWidth = -1;
        public float dashWidth = 0.0f;
        public float dashGap = 0.0f;

    }
}
