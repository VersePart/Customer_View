package com.wangyang.cuseomerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SunriseViewGroup extends ViewGroup {

	private static String TAG = "verse_part";
	public SunriseViewGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public SunriseViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public SunriseViewGroup(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	private void init() {
		// TODO Auto-generated method stub
	}
	/*
	 * (non-Javadoc)
	 * @see android.view.View#onMeasure(int, int)
	 * 当是 MeasureSpec.AT_MOST时需要重新测量 ,这里省略(因为不是MeasureSpec.AT_MOST,偷下懒 嘻嘻)
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		measureChildren(widthMeasureSpec, heightMeasureSpec);
		int childCount = getChildCount();
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		Log.i(TAG, " onMeasure  widthSize = "+widthSize+"  heightSize ="+heightSize);
		if(childCount == 0){
			setMeasuredDimension(0, 0);
		}/* else if(widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
			
		} else if(widthMode == MeasureSpec.AT_MOST){
			
		} else if(heightMode == MeasureSpec.AT_MOST){
			
		}*/else{
			setMeasuredDimension(widthSize, heightSize);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.view.ViewGroup#onLayout(boolean, int, int, int, int)
	 * 实现了RelativeLayout 和 LinearLayout效果
	 */
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		int childCount = getChildCount();
		int maxChildHeight = 0;
		int childAddWidth = l;
		ImageView childView;
		int childWidth;
		int childHeight;
		for(int i = 0; i<childCount; i++){
			if(i == (childCount - 1)){
				childView = (ImageView) getChildAt(i);
				childWidth = childView.getMeasuredWidth();
				childHeight = childView.getMeasuredHeight();
				childView.layout(l, maxChildHeight +10, l+childWidth, maxChildHeight+childHeight +10);
			} else{
				childView = (ImageView) getChildAt(i);
				childWidth = childView.getMeasuredWidth();
				childHeight = childView.getMeasuredHeight();
				childView.layout(childAddWidth, t, childWidth+childAddWidth, childHeight+t);
				childAddWidth += childWidth + 10;
				if(maxChildHeight < childHeight){
					maxChildHeight = childHeight;
				}
			}
			Log.i(TAG, " onLayout  childWidth = "+childWidth +"  childHeight = "+childHeight );
		}
	}
}