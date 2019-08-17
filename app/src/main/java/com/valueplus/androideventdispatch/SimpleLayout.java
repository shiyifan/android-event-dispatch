package com.valueplus.androideventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import static android.view.MotionEvent.actionToString;

class SimpleLayout extends LinearLayout {
    boolean retOnTouch = false;
    boolean retDispatch = false;
    boolean retOnIntercept = false;

    public SimpleLayout(Context context) {
        super(context);
    }

    public SimpleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SimpleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.wtf("*** SimpleLayout onTouchEvent", actionToString(event.getAction()) + "--start");
        super.onTouchEvent(event);
        Log.wtf("*** SimpleLayout onTouchEvent", actionToString(event.getAction()) + "--end: " + retOnTouch);
        return retOnTouch;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.wtf("*** SimpleLayout onInterceptTouchEvent", actionToString(ev.getAction()) + "--start");
        super.onInterceptTouchEvent(ev);
        Log.wtf("*** SimpleLayout onInterceptTouchEvent", actionToString(ev.getAction()) + "--end: " + retOnIntercept);
        return retOnIntercept;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.wtf("*** SimpleLayout dispatchTouchEvent", actionToString(ev.getAction()) + "--start");
        boolean bl = super.dispatchTouchEvent(ev);
        if (retDispatch) {
            Log.wtf("*** SimpleLayout dispatchTouchEvent", actionToString(ev.getAction()) + "--end: " + retDispatch);
            return retDispatch;
        }
        Log.wtf("*** SimpleLayout dispatchTouchEvent", actionToString(ev.getAction()) + "--end: " + bl);
        return bl;
    }
}
