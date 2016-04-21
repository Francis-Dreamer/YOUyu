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

public class DongtaiActivity extends Activity {
	ListView list_dongtai;
	DongtaiBaseAdapter dongtaiBaseAdapter;
	ArrayList<Dongtai_data> list = new ArrayList<Dongtai_data>();

	ImageView image_fanhui;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dongtai);
		list_dongtai = (ListView) findViewById(R.id.list_dongtai);
		getData();
		dongtaiBaseAdapter = new DongtaiBaseAdapter(DongtaiActivity.this, list);
		list_dongtai.setAdapter(dongtaiBaseAdapter);

		image_fanhui = (ImageView) findViewById(R.id.image_fanhui);
		image_fanhui.setOnClickListener(ocl);
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.image_fanhui:
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

		Dongtai_data data2 = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		Dongtai_data data3 = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		Dongtai_data data4 = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		Dongtai_data data5 = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);

		Dongtai_data data6 = new Dongtai_data();
		data.setImage_ciqiko(R.drawable.ciqiko);
		data.setText_ciqiko("磁器口");
		data.setImage_ciqikoyonghutouxiang(R.drawable.ciqikoyonghutouxiang);
		data.setText_yonghu("美丽人生");
		data.setText_biaoti("我在这里带走的文化与历史");
		data.setText_leirong("磁器口，一个古风古韵的地方，这里除了繁华的街景还有");
		list.add(data);
	}
}
