package com.example.youyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.youyu.baseadapter.OldTimeyBaseAdapter;
import com.example.youyu.model.OldTimeYModel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class OldTimeyActivity extends Activity{
	ExpandableListView listView;
	OldTimeyBaseAdapter oldTimeyBaseAdapter;
	List<OldTimeYModel> list;
	OldTimeYModel model;
	Map<String, List<OldTimeYModel>> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yu_oldtimey);
		listView=(ExpandableListView)findViewById(R.id.listview_yu_oldtimey);
	getData();
		oldTimeyBaseAdapter=new OldTimeyBaseAdapter(list, this);
		listView.setAdapter(oldTimeyBaseAdapter);
	}
	public void getData(){
		list =new ArrayList<OldTimeYModel>();
		model=new OldTimeYModel();
		model.setMonth("十二月");
		list.add(model);
		map=new HashMap<String, List<OldTimeYModel>>();
		list =new ArrayList<OldTimeYModel>();
		model=new OldTimeYModel();
		model.setMonth("十二月");
		model.setPic(R.drawable.xiannvshan);
		model.setPic_name("仙女山");
		list.add(model);
		map.put("十二月", list);
	}
}
