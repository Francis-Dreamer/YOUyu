package com.example.youyu.adapter;

import java.util.List;

import com.example.youyu.R;
import com.example.youyu.model.DraftboxsModel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DraftboxsAdapter extends BaseAdapter{

	List<DraftboxsModel> data;
	Context context;
	LayoutInflater inflater;
	
	public DraftboxsAdapter(){
		
	}
	
	public DraftboxsAdapter(List<DraftboxsModel> data,Context context){
		this.data=data;
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	public void setData(List<DraftboxsModel> data){
		this.data=data;
		this.notifyDataSetChanged();
	}
	
	public int getCount() {
		if(data!=null){
			return data.size();
		}else{
			return 0;
		}
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams") public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.every_draftsbox, null);
			holder.title=(TextView) convertView.findViewById(R.id.draftboxs_title);
			holder.content=(TextView) convertView.findViewById(R.id.draftboxs_content);
			holder.time=(TextView) convertView.findViewById(R.id.draftboxs_time);
			holder.pic=(ImageView) convertView.findViewById(R.id.draftboxs_pic);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		DraftboxsModel model=(DraftboxsModel) getItem(position);
		
		holder.title.setText(model.getTitle());
		holder.content.setText(model.getContent());
		holder.time.setText(model.getTime());
		holder.pic.setImageResource(Integer.parseInt(model.getPic()));
		
		return convertView;
	}

	class ViewHolder{
		TextView title;
		TextView content;
		TextView time;
		ImageView pic;
	}
}
