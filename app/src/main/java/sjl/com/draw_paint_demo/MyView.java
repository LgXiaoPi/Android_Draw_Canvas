package sjl.com.draw_paint_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        //画圆
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#FFFF00"));
        paint.setStrokeWidth(10f);

        /**
         * canvas
         */
//        //画一个点
//        canvas.drawPoint(200, 200, paint);
//        //画多个点
//        canvas.drawPoints(new float[]{200, 300, 300, 300, 400, 300}, paint);

//        //画一条线
//        canvas.drawLine(200, 300, 600, 300, paint);
//        //画多条线
//        canvas.drawLines(new float[]{200, 550, 350, 850, 200, 550, 600, 850},paint);

//        //画矩形
//        //paint.setStyle(Paint.Style.FILL);这里设置的填充，如果想画空心的设置style为STROKE
//        //第一种
//        canvas.drawRect(100, 200, 300, 400, paint);
//        //第二种
//        Rect rect = new Rect(100, 200, 300, 400);
//        canvas.drawRect(rect,paint);
//        //第三种
//        RectF rectF = new RectF(100, 200, 300, 400);
//        canvas.drawRect(rectF,paint);

//        //画圆角矩形
//        //第一种
//        canvas.drawRoundRect(100, 200, 800, 600, 80, 80, paint);
//        //第二种
//        RectF rectF = new RectF(100, 200, 800, 600);
//        canvas.drawRoundRect(rectF, 80, 80, paint);

//        //画椭圆
//        //第一种
//        canvas.drawOval(100, 200, 900, 600, paint);
//        //第二种
//        RectF rectF = new RectF(100, 200, 900, 600);
//        canvas.drawOval(rectF,paint);

//        //画圆
//        canvas.drawCircle(500, 500, 250, paint);

//        //画弧
//        //先画个底部的背景矩形
//        RectF rectF = new RectF(100, 200, 600, 500);
//        paint.setColor(Color.GRAY);
//        canvas.drawRect(rectF, paint);
//        //startAngle:开始角度，sweepAngle：画的角度，useCenter:是否使用圆心
//        paint.setColor(Color.parseColor("#FFFF00"));
//        //canvas.drawArc(rectF, 0, 90, false, paint);
//        canvas.drawArc(rectF, 0, 90, true, paint);


        /**
         * path
         */
        Path mPath = new Path();

//        //画线
//        mPath.lineTo(300, 300);
//        mPath.lineTo(800, 400);
//        //setLastPoint是设置最后点的位置坐标，影响的是上一步的操作
//        mPath.setLastPoint(300, 500);
//        mPath.lineTo(600, 500);
//        //rLineTo就是在原有的坐标下（x+100,y+100）
//        mPath.rLineTo(100, 100);
//        mPath.moveTo(300,800);
//        mPath.rLineTo(300,100);

        //绘制基本图形
        //画圆
        //addCircle(float x, float y, float radius, Direction dir)
        mPath.addCircle(300, 300, 100, Path.Direction.CW);

        //画椭圆
        //addOval(RectF oval, Direction dir)
        //addOval(float left, float top, float right, float bottom, Direction dir)
        RectF rectF = new RectF(500, 200, 900, 400);
        mPath.addOval(rectF, Path.Direction.CW);

        //绘制矩形
        //addRect(RectF rect, Direction dir)
        //addRect(float left, float top, float right, float bottom, Direction dir)
        RectF rectF1 = new RectF(100, 500, 500, 800);
        mPath.addRect(rectF1, Path.Direction.CW);

        //绘制圆角矩形
        //addRoundRect(RectF rect, float rx, float ry, Direction dir)
        //addRoundRect(float left, float top, float right, float bottom, float rx, float ry,Direction dir)
        //addRoundRect(RectF rect, float[] radii, Direction dir)
        //addRoundRect(float left, float top, float right, float bottom, float[] radii,Direction dir)
        RectF rectF2 = new RectF(600, 500, 1000, 800);
        mPath.addRoundRect(rectF2, 100, 100, Path.Direction.CW);
        RectF rectF3 = new RectF(100, 900, 600, 1200);
        mPath.addRoundRect(rectF3, new float[]{100, 100, 50, 50, 0, 0, 100, 50}, Path.Direction.CW);

        //绘制弧
        //addArc(RectF oval, float startAngle, float sweepAngle)
        //addArc(float left, float top, float right, float bottom, float startAngle,float sweepAngle)
        //forceMoveTo：是否强制将path最后一个点移动到圆弧起点，
        //true是强制移动，即为不连接两个点；false则连接两个点
        //arcTo(RectF oval, float startAngle, float sweepAngle,boolean forceMoveTo)
        //arcTo(RectF oval, float startAngle, float sweepAngle)
        //arcTo(float left, float top, float right, float bottom, float startAngle,float sweepAngle, boolean forceMoveTo)
        RectF rectF4 = new RectF(100, 1300, 300, 1500);
        mPath.addArc(rectF4, 0, 200);
        RectF rectF5 = new RectF(400, 1300, 600, 1500);
        mPath.arcTo(rectF5, -90, 100, true);
        RectF rectF6 = new RectF(700, 1300, 900, 1500);
        mPath.arcTo(rectF6, -60, 160, false);

        canvas.drawPath(mPath, paint);
    }
}
