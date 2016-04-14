package com.example.youyu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MyFrameLayout extends FrameLayout {
	private OnMeasureListener onMeasureListener;

	public MyFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if(onMeasureListener != null){
//			onMeasureListener.onMeasureListener(height);
		}
		
	}

	public interface OnMeasureListener {
		public void onMeasureListener(int height);
	}

	public void setOnMeasureListener(OnMeasureListener onMeasureListener) {
		this.onMeasureListener = onMeasureListener;
	}

}
