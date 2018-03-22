package com.song.parabolicanimationdemo;

import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static String TAG;

    private int startX;
    private int startY;

    private int endX;
    private int endY;

    private int pointX;
    private int pointY;

    private int endPosition[]=new int[2];

    private ConstraintLayout father;
    private ImageView ivEnd;
    NXHooldeView nxHooldeView;

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

        endX=ivEnd.getLeft()+(ivEnd.getWidth()/2);
        endY=ivEnd.getTop()+(ivEnd.getHeight()/2);
        Log.e(TAG,endX+"---"+endY);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if (motionEvent.getAction()==MotionEvent.ACTION_UP){
            Log.e(TAG,motionEvent.getX()+"--"+motionEvent.getY());
            startX=(int)motionEvent.getX();
            startY=(int)motionEvent.getY();
            nxHooldeView=new NXHooldeView(this);
            father.addView(nxHooldeView);
            nxHooldeView.setStartPosition(new Point(startX,startY));
            nxHooldeView.setEndPosition(new Point(endX,endY));
            nxHooldeView.startBeizerAnimation();
        }

        return true;
    }
}
