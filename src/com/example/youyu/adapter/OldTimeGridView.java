package com.example.youyu.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class OldTimeGridView extends GridView {
	public OldTimeGridView(Context context) {
		super(context);
	}

	public OldTimeGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
