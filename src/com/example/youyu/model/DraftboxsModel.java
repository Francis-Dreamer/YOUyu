package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;

public class DraftboxsModel {

	String id;
	String username;
	String title;
	String content;
	String time;
	String pic;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public static List<DraftboxsModel> getData(){
		List<DraftboxsModel> data=new ArrayList<DraftboxsModel>();
		DraftboxsModel model;
		for (int i = 0; i < 4; i++) {
			model=new DraftboxsModel();
			model.setTitle("草稿箱标题测试数据"+i);
			model.setContent("草稿箱内容测试数据"+i);
			model.setTime("草稿箱时间测试数据"+i);
			model.setPic(R.drawable.yangrenyangren+"");
			data.add(model);
		}
		return data;
	}

}
