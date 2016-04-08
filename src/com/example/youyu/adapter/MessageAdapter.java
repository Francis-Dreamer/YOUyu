package com.example.youyu.adapter;

import java.util.List;
import com.example.youyu.R;
import com.example.youyu.model.MessageModel;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter{

	List<MessageModel> data;
	Context context;
	LayoutInflater inflater;
	
	public MessageAdapter(){
		
	}
	
	public MessageAdapter(List<MessageModel> data,Context context){
		this.data=data;
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	public void setData(List<MessageModel> data){
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
			convertView=inflater.inflate(R.layout.every_message, null);
			holder.source=(TextView) convertView.findViewById(R.id.message_source);
			holder.do_what=(TextView) convertView.findViewById(R.id.do_what);
			holder.content=(TextView) convertView.findViewById(R.id.message_content);
			holder.time=(TextView) convertView.findViewById(R.id.message_time);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		MessageModel model=(MessageModel) getItem(position);
		holder.source.setText(model.getSource());
		holder.do_what.setText(model.getDo_what());
		holder.content.setText(model.getContent());
		holder.time.setText(model.getTime());
		
		return convertView;
	}
	
	class ViewHolder{
		TextView source;
		TextView content;
		TextView do_what;
		TextView time;
	}

}
