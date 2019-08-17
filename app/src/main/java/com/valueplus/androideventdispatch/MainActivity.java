package com.valueplus.androideventdispatch;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.MotionEvent.actionToString;

public class MainActivity extends AppCompatActivity {
    boolean retOnTouch = false;
    boolean retDispatch = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.wtf("* Activity onTouchEvent", actionToString(event.getAction()) + "--start");
        super.onTouchEvent(event);
        Log.wtf("* Activity onTouchEvent", actionToString(event.getAction()) + "--end: " + retOnTouch);
        return retOnTouch;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.wtf("* Activity dispatchTouchEvent", actionToString(ev.getAction()) + "--start");
        boolean bl = super.dispatchTouchEvent(ev);
        if (retDispatch) {
            Log.wtf("* Activity dispatchTouchEvent", actionToString(ev.getAction()) + "--end: " + retDispatch);
            return retDispatch;
        }
        Log.wtf("* Activity dispatchTouchEvent", actionToString(ev.getAction()) + "--end: " + bl);
        return bl;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleView sv = findViewById(R.id.simpleView);
        SimpleLayout sl = findViewById(R.id.simpleLayout);
        Switch swActvTouch = findViewById(R.id.swActvTouch);
        Switch swLaytTouch = findViewById(R.id.swLaytTouch);
        Switch swViewTouch = findViewById(R.id.swViewTouch);
        Switch swLaytIntercept = findViewById(R.id.swLaytIntercept);
        Switch swActvDispatch = findViewById(R.id.swActvDispatch);
        Switch swLaytDispatch = findViewById(R.id.swLaytDispatch);
        Switch swViewDispatch = findViewById(R.id.swViewDispatch);

        swActvTouch.setOnCheckedChangeListener((v, checked) -> retOnTouch = checked);
        swLaytTouch.setOnCheckedChangeListener((v, checked) -> sl.retOnTouch = checked);
        swViewTouch.setOnCheckedChangeListener((v, checked) -> sv.retOnTouch = checked);
        swLaytIntercept.setOnCheckedChangeListener((v, checked) -> sl.retOnIntercept = checked);
        swActvDispatch.setOnCheckedChangeListener((v, checked) -> retDispatch = checked);
        swLaytDispatch.setOnCheckedChangeListener((v, checked) -> sl.retDispatch = checked);
        swViewDispatch.setOnCheckedChangeListener((v, checked) -> sv.retDispatch = checked);
    }
}
