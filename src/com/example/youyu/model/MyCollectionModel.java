package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;

public class MyCollectionModel {

	String id;
	String username;
	String title;
	String content;
	String time;
	String pic1;
	String pic2;

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

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

	public static List<MyCollectionModel> getData() {
		List<MyCollectionModel> data = new ArrayList<MyCollectionModel>();
		MyCollectionModel model;
		for (int i = 0; i < 4; i++) {
			model=new MyCollectionModel();
			model.setTitle("我的收藏标题测试数据"+i);
			model.setContent("我的收藏内容测试数据"+i);
			model.setTime("我的收藏时间测试数据"+i);
			model.setPic1(R.drawable.tuzuozuo+"");
			model.setPic2(R.drawable.tuyouyou+"");
			data.add(model);
		}

		return data;
	}

}
