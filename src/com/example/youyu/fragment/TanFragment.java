package com.example.youyu.fragment;

import com.example.youyu.DongtaiActivity;
import com.example.youyu.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * 探的首页
 * 
 * @author Administrator
 *
 */
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

	GridView gview;

	RadioButton radioBtn;
	RadioButton rbutton_renshu;
	RadioButton rbutton_guanxi;
	RadioButton rbutton_shijian;

	Button button_tan;

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

		radioBtn = (RadioButton) view.findViewById(R.id.yuzhong_radiobtn);
		rbutton_renshu = (RadioButton) view.findViewById(R.id.rbutton_renshu);
		rbutton_guanxi = (RadioButton) view.findViewById(R.id.rbutton_guanxi);
		rbutton_shijian = (RadioButton) view.findViewById(R.id.rbutton_shijian);

		gview = (GridView) view.findViewById(R.id.gview);

		button_tan = (Button) view.findViewById(R.id.button_tan);

		radioBtn.setChecked(true);
		rbutton_renshu.setChecked(true);
		rbutton_shijian.setChecked(true);

		text_didian = (TextView) view.findViewById(R.id.text_didian);

		text_dengdeng.setOnClickListener(ocl);
		text_didian.setOnClickListener(ocl);

		button_tan.setOnClickListener(ocl);
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
			case R.id.button_tan:
				//点击探跳转到动态页面
				Intent intent = new Intent(getActivity(), DongtaiActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

	/**
	 * 显示其它区县
	 */
	@SuppressWarnings("static-access")
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
	@SuppressWarnings("static-access")
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
