package com.jish.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int width;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display dis = this.getWindowManager().getDefaultDisplay();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 获取屏幕宽度
        width = dis.getWidth();
        // 获取屏幕高度
        height  = dis.getHeight();
        Log.e("hxl","width=="+width+"       height=="+height);
        LinearLayout main = (LinearLayout)findViewById(R.id.root) ;
        final CostomView draw1 = new CostomView(this,width,height) ;
        draw1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                //可用  接近答案
//               int currentX = (int) event.getX();
//               int currentY = (int) event.getY();
//                draw1.left =  width -  currentX;
//                draw1.top = height - currentY;
//                draw1.right =  draw1.left+100;
//                draw1.bottom =   draw1.top+100;


                int currentX = (int) event.getX();
                int currentY = (int) event.getY();
                draw1.right =  currentX+100;
                draw1.bottom = currentY+100;
                draw1.left = draw1.right-100;
                draw1.top =  draw1.bottom-100;


                // 通知重绘
                draw1.postInvalidate();   //该方法会调用onDraw方法，重新绘图
//
                return true ;
            }

        }) ;
        main.addView(draw1) ;
        //绘制第一次显示在左上角的正方形
        draw1.right =  100;
        draw1.bottom = 100;
        draw1.left = 0;
        draw1.top =  0;
        draw1.postInvalidate();
    }

}
