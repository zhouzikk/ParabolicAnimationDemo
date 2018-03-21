package com.song.parabolicanimationdemo;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static String TAG;

    private float startX;
    private float startY;

    private float endX;
    private float endY;

    private int endPosition[]=new int[2];

    private ConstraintLayout father;
    private ImageView ivEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG=this.getClass().getName();
        father=findViewById(R.id.father_);
        father.setOnTouchListener(this);
        ivEnd=findViewById(R.id.iv_end);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        endX=ivEnd.getTop();
        endY=ivEnd.getLeft();

        Log.e(TAG,endX+"---"+endY);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if (motionEvent.getAction()==MotionEvent.ACTION_UP){
            Log.e(TAG,motionEvent.getX()+"--"+motionEvent.getY());
            startX=motionEvent.getX();
            startY=motionEvent.getY();
        }

        return true;
    }
}
