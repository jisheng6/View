package com.jish.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/4/24.
 */

public class CostomView extends View{
    private int screenW;
    private int screenH;

    public int left=100;
    public int top=100;
    public int right=100;
    public int bottom=100;
    Paint paint  = new Paint();

    public CostomView(Context context) {
        super(context);
    }

    public CostomView(Context context, int screenW, int screenH) {
        super(context);
        this.screenW = screenW;
        this.screenH = screenH;
    }

    public CostomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("hxl", "---widthMeasureSpec-----"+widthMeasureSpec+"-----------heightMeasureSpec------"+heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.WHITE);
        // 设置颜色
        paint.setColor(Color.RED);
        //样式填充
        paint.setStyle(Paint.Style.FILL);

        revise();//修正正方形坐标，让它不超出屏幕范围

        Log.e("hxl","canvas=====left=="+left+"==top==="+top+"===right=="+right+"==bottom=="+bottom);
//         绘制一个矩形
        canvas.drawRect(left,top, right,bottom, paint);
    }


    //修正坐标
    private void revise(){

        if(right<=100){//left
            right = 100;
        }
        if(left>=(screenW-100)){//right
            left =(screenW-100);
        }
        if(top>=(screenH-100)){//bottom
            top =(screenH-100);
        }
        if(bottom<=100){//tops
            bottom=100;
        }
    }
}
