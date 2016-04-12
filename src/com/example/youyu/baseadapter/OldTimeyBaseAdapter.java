package com.example.youyu.baseadapter;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;
import com.example.youyu.adapter.OldTimeGridView;
import com.example.youyu.model.OldTimeYModel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OldTimeyBaseAdapter extends BaseExpandableListAdapter {
	LayoutInflater inflater;
	Context context;
	List<OldTimeYModel> list;
	List<OldTimeYModel> gridList;

	public OldTimeyBaseAdapter() {

	}

	@SuppressWarnings("static-access")
	public OldTimeyBaseAdapter(List<OldTimeYModel> list, Context context) {
		this.list = list;
		this.context = context;
		inflater = (LayoutInflater) inflater.from(context);
	}

	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return list.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return 1;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_yu_oldtimey, null);
			holder.oldTime_month = (TextView) convertView
					.findViewById(R.id.old_time_month);
			holder.oldtime_thismonth = (ImageView) convertView
					.findViewById(R.id.oldtime_thismonth);
			convertView.setTag(holder);
		}
		OldTimeYModel model = (OldTimeYModel) getGroup(groupPosition);
		holder = (ViewHolder) convertView.getTag();
		holder.oldTime_month.setText(model.getMonth());
		if (isExpanded) {
			holder.oldtime_thismonth
					.setImageResource(R.drawable.this_month_xiala);
		} else {
			holder.oldtime_thismonth.setImageResource(R.drawable.this_month);
		}
		return convertView;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.gridview_oldtime, null);
			holder.gridView = (OldTimeGridView) convertView
					.findViewById(R.id.gridview_oldtime);
			convertView.setTag(holder);
		}

		holder = (ViewHolder) convertView.getTag();
		initImage();
		OldTimeGridViewBaseAdapter adapter = new OldTimeGridViewBaseAdapter(
				context, gridList);
		holder.gridView.setAdapter(adapter);
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	class ViewHolder {
		TextView oldTime_month;
		ImageView imageView;
		TextView pic_name;
		ImageView oldtime_thismonth;
		OldTimeGridView gridView;
	}

	public void initImage() {
		gridList = new ArrayList<OldTimeYModel>();
		for (int i = 0; i < 4; i++) {
			OldTimeYModel model = new OldTimeYModel();
			model.setPic(R.drawable.xiannvshan);
			model.setPic_name("仙女山");
			gridList.add(model);
		}
	}
}
