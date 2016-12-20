package com.wangyang.cuseomerview;

import com.wangyang.cuseomerview.R.styleable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RadiuView extends View {

	private Paint mPaint;
	private int mRadiu;
	private static String TAG = "verse_part";

	public RadiuView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context,attrs);
		// TODO Auto-generated constructor stub
	}

	public RadiuView(Context context) {
		
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	private void init(Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		mPaint = new Paint();
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BuleRadiu);
		mRadiu = typedArray.getDimensionPixelOffset(styleable.BuleRadiu_radiu, 10);
		Log.i(TAG, " init  mRadiu = "+mRadiu); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.view.View#onMeasure(int, int)
	 * widthMeasureSpec和heightMeasureSpec是一个32位的二进制数,前两位是mode,后30位是尺寸,该参数提供给我们建议的尺寸,但我们可以根据自己的需要自己定义尺寸
	 */
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		setMeasuredDimension(widthSize, heightSize);//这里才是真正的测量,两个参数根据实际需要传递需要的尺寸
//		setMeasuredDimension(50, 50); 
		Log.i(TAG, " widthMode = "+widthMode +"  widthSize = "+widthSize);
	}
	  
	/*
	 * (non-Javadoc) 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 * 如果需要动态的改变view可通过Piant和Canvas完成
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
//		super.onDraw(canvas);
		int padding = getPaddingTop();
		Log.i(TAG, " onDraw  padding = "+padding); 
		mPaint.setColor(Color.BLUE);
		mPaint.setAntiAlias(true);
		int widthMeasure = getMeasuredWidth();
		int heightMeasure = getMeasuredHeight();
		int circle = Math.min(widthMeasure, heightMeasure)/2 - padding;
		canvas.drawCircle(widthMeasure/2, heightMeasure/2, circle, mPaint);//绘制圆
		mPaint.setColor(Color.BLUE);
		canvas.drawCircle(0, 0, mRadiu, mPaint);//绘制1/4圆弧
	}
}