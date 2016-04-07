package com.example.youyu.baseadapter;

import java.util.List;
import java.util.Map;

import com.example.youyu.R;
import com.example.youyu.model.OldTimeYModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OldTimeyBaseAdapter extends BaseExpandableListAdapter {
	List<OldTimeYModel> oldTimeYModels;
	Map<String, List<OldTimeYModel>> map;
	LayoutInflater inflater;
	Context context;

	public OldTimeyBaseAdapter() {

	}

	@SuppressWarnings("static-access")
	public OldTimeyBaseAdapter(List<OldTimeYModel> oldTimeYModels,
			Context context) {
		this.oldTimeYModels = oldTimeYModels;
		this.context = context;
		inflater = (LayoutInflater) inflater.from(context);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return oldTimeYModels.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		OldTimeYModel key = oldTimeYModels.get(groupPosition);
		int size = map.get(key).size();
		return size;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return oldTimeYModels.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		OldTimeYModel key = oldTimeYModels.get(groupPosition);
		return (map.get(key).get(childPosition));
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		OldTimeYModel oldTimeYModel = (OldTimeYModel) oldTimeYModels
				.get(groupPosition);
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_yu_oldtimey,
					null);
			holder.oldTime_month = (TextView) convertView
					.findViewById(R.id.old_time_month);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.oldTime_month.setText(oldTimeYModel.getMonth());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		OldTimeYModel oldTimeYModel = (OldTimeYModel) oldTimeYModels
				.get(groupPosition);
		OldTimeYModel info = map.get(oldTimeYModel).get(childPosition);
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_yu_oldtimey_image,
					null);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.this_month_image);
			holder.pic_name = (TextView) convertView
					.findViewById(R.id.image_text_name);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.imageView.setBackgroundResource(info.getPic());
		holder.pic_name.setText(info.getPic_name());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	class ViewHolder {
		TextView oldTime_month;
		TextView pic_name;
		ImageView imageView;
	}
}
