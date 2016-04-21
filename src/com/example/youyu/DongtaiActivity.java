package com.example.youyu;

import java.util.ArrayList;

import com.example.youyu.adapter.DongtaiBaseAdapter;
import com.example.youyu.adapter.Dongtai_data;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DongtaiActivity extends Activity {
	ListView list_dongtai;
	DongtaiBaseAdapter dongtaiBaseAdapter;
	ArrayList<Dongtai_data> list = new ArrayList<Dongtai_data>();

	ImageView iv_back,iv_menu;
	TextView tv_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dongtai);
		
		list_dongtai = (ListView) findViewById(R.id.list_dongtai);
		getData();
		dongtaiBaseAdapter = new DongtaiBaseAdapter(DongtaiActivity.this, list);
		list_dongtai.setAdapter(dongtaiBaseAdapter);

		iv_back = (ImageView) findViewById(R.id.top_imageview);
		iv_menu = (ImageView) findViewById(R.id.image_search);
		iv_menu.setVisibility(View.GONE);
		iv_back.setOnClickListener(ocl);
		iv_back.setImageResource(R.drawable.fanhui);
		
		tv_title = (TextView) findViewById(R.id.top_title);
		tv_title.setText("探");
	}

	OnClickListener ocl = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.top_imageview:
				finish();
				break;
			default:
				break;
			}
		}
	};

	public void getData() {
		Dongtai_data data = new Dongtai_data();
		
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		data = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		data = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		data = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		data = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		data = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);
	}
}
