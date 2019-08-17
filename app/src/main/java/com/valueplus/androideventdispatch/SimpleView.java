package com.valueplus.androideventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import static android.view.MotionEvent.actionToString;

class SimpleView extends View {

    boolean retOnTouch = false;
    boolean retDispatch = false;

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.wtf("****** SimpleView onTouchEvent", actionToString(event.getAction()) + "--start");
        boolean bl = super.onTouchEvent(event);
        Log.wtf("****** SimpleView onTouchEvent", actionToString(event.getAction()) + "--end: " + retOnTouch);
        return retOnTouch;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.wtf("****** SimpleView dispatchTouchEvent", actionToString(event.getAction()) + "--start");
        boolean bl = super.dispatchTouchEvent(event);
        if (retDispatch) {
            Log.wtf("****** SimpleView dispatchTouchEvent", actionToString(event.getAction()) + "--end: " + retDispatch);
            return retDispatch;
        }
        Log.wtf("****** SimpleView dispatchTouchEvent", actionToString(event.getAction()) + "--end: " + bl);
        return bl;
    }
}
