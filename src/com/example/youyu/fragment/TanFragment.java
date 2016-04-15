package com.example.youyu.fragment;

import com.example.youyu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TanFragment extends Fragment {
	View view;
	TextView text_dengdeng;

	TextView text_shuangqiao;
	LinearLayout linear_otherone;
	LinearLayout linear_othertwo;
	LinearLayout linear_otherthree;
	LinearLayout linear_otherfour;
	LinearLayout linear_otherfive;
	LinearLayout linear_othersix;
	LinearLayout linear_otherseven;
	LinearLayout linear_othereight;

	TextView text_didian;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_tan, null);
		text_dengdeng = (TextView) view.findViewById(R.id.text_dengdeng);
		text_shuangqiao = (TextView) view.findViewById(R.id.text_shuangqiao);
		linear_otherone = (LinearLayout) view.findViewById(R.id.linear_otherone);
		linear_othertwo = (LinearLayout) view.findViewById(R.id.linear_othertwo);
		linear_otherthree = (LinearLayout) view.findViewById(R.id.linear_otherthree);
		linear_otherfour = (LinearLayout) view.findViewById(R.id.linear_otherfour);
		linear_otherfive = (LinearLayout) view.findViewById(R.id.linear_otherfive);
		linear_othersix = (LinearLayout) view.findViewById(R.id.linear_othersix);
		linear_otherseven = (LinearLayout) view.findViewById(R.id.linear_otherseven);
		linear_othereight = (LinearLayout) view.findViewById(R.id.linear_othereight);

		text_didian = (TextView) view.findViewById(R.id.text_didian);

		text_dengdeng.setOnClickListener(ocl);
		text_didian.setOnClickListener(ocl);

		return view;
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.text_dengdeng:
				show();
				break;
			case R.id.text_didian:
				notShown();
				break;
			default:
				break;
			}
		}
	};

	/**
	 * 显示其它区县
	 */
	public void show() {
		text_dengdeng.setVisibility(view.GONE);
		text_shuangqiao.setVisibility(view.VISIBLE);
		linear_otherone.setVisibility(view.VISIBLE);
		linear_othertwo.setVisibility(view.VISIBLE);
		linear_otherthree.setVisibility(view.VISIBLE);
		linear_otherfour.setVisibility(view.VISIBLE);
		linear_otherfive.setVisibility(view.VISIBLE);
		linear_othersix.setVisibility(view.VISIBLE);
		linear_otherseven.setVisibility(view.VISIBLE);
		linear_othereight.setVisibility(view.VISIBLE);
	}

	/**
	 * 未显示其它区县
	 */
	public void notShown() {
		text_dengdeng.setVisibility(view.VISIBLE);
		text_shuangqiao.setVisibility(view.GONE);
		linear_otherone.setVisibility(view.GONE);
		linear_othertwo.setVisibility(view.GONE);
		linear_otherthree.setVisibility(view.GONE);
		linear_otherfour.setVisibility(view.GONE);
		linear_otherfive.setVisibility(view.GONE);
		linear_othersix.setVisibility(view.GONE);
		linear_otherseven.setVisibility(view.GONE);
		linear_othereight.setVisibility(view.GONE);
	}

}
