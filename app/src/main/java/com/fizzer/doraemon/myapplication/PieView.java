package com.fizzer.doraemon.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by Fizzer on 2016/11/22.
 * Email: doraemonmqq@sina.com
 */

public class PieView extends View {

    private List<Integer> dataList;
    private List<Integer> colorList;

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(100, 50, 500, 450);

        float scaleStart = 0;
        int total = getTotal();
        for (int index = 0; index < dataList.size(); index++) {
            float scalDegree = getScaleDegree(total, dataList.get(index));
            if(index == dataList.size() - 1){
                scalDegree = 360 - scaleStart;
            }
            drawArc(canvas, rectF, scaleStart, scalDegree, colorList.get(index),paint);
            scaleStart += scalDegree;
        }

    }

    /**
     * 画扇形
     *
     * @param canvas    canvas
     * @param rectF     rectF
     * @param scaleStart    scaleStart
     * @param scaleEnd  scaleEnd
     * @param color     color
     * @param paint     paint
     */
    private void drawArc(Canvas canvas, RectF rectF, float scaleStart, float scaleEnd, int color, Paint paint) {
        paint.setColor(color);
        canvas.drawArc(rectF, scaleStart, scaleEnd, true, paint);
    }

    /**
     * 设置数据
     *
     * @param dataList dataList
     */
    public void setData(List<Integer> dataList) {
        this.dataList = dataList;
    }

    /**
     * 获取对应的角度
     *
     * @param total total
     * @param item  item
     * @return degree
     */
    private float getScaleDegree(int total, int item) {
        return 360 * item / total;
    }

    /**
     * 获取数据总和
     *
     * @return total
     */
    private int getTotal() {
        int total = 0;
        for (int data : dataList) {
            total += data;
        }
        return total;
    }

    /**
     * 设置颜色数据
     *
     * @param colorList colorList
     */
    public void setColorData(List<Integer> colorList) {
        this.colorList = colorList;
    }
}
