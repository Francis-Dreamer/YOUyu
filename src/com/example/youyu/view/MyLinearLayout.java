package com.example.youyu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {
	private OnMeasureListener onMeasureListener;

	public MyLinearLayout(Context context) {
		super(context);
	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (onMeasureListener != null) {
			onMeasureListener.onMeasureListener(getMeasuredWidth(),
					getMeasuredHeight());
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public interface OnMeasureListener {
		public void onMeasureListener(int width, int height);
	}

	public void setOnMeasureListener(OnMeasureListener onMeasureListener) {
		this.onMeasureListener = onMeasureListener;
	}
	 @Override  
	    protected void onDraw(Canvas canvas) {  
	        super.onDraw(canvas);  
	    } 
}
