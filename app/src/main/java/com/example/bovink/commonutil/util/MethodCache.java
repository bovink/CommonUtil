package com.example.bovink.commonutil.util;

import android.graphics.ColorMatrixColorFilter;
import android.view.MotionEvent;
import android.view.View;

/**
 * 保存一些有用的方法
 *
 * @author bovink
 * @since 2016/9/11
 */
public class MethodCache {

    /**
     * 添加触摸变色效果
     * @param view 变色的视图
     */
    private void setClickFade(View view, final int touchLum) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 如果父布局不为空且可点击，则执行触摸事件
                if (v.getParent() != null) {
                    View parent = (View) v.getParent();
                    if (parent.isClickable()) {
                        parent.onTouchEvent(event);
                    }
                }
                if (v.isClickable()) {
                    // 获取触摸时变化的亮度，其他值为公式
                    float lum = (touchLum - 50) * 2 * 255 * 0.01f;
                    // 响应触摸事件
                    switch (event.getActionMasked()) {
                        case MotionEvent.ACTION_DOWN:
                            v.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[]{
                                    1, 0, 0, 0, lum,
                                    0, 1, 0, 0, lum,
                                    0, 0, 1, 0, lum,
                                    0, 0, 0, 1, 0
                            }));
                            break;
                        case MotionEvent.ACTION_UP:
                            v.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[]{
                                    1, 0, 0, 0, 0,
                                    0, 1, 0, 0, 0,
                                    0, 0, 1, 0, 0,
                                    0, 0, 0, 1, 0
                            }));
                            break;
                    }
                }
                return true;
            }
        });
    }
}
