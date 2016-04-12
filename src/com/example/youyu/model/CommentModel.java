package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;

public class CommentModel {
	String comment_name;
	String comment_time;
	int comment_pic;
	String comment_text;
	String user_name;
	String user_name_text;
	public String getUser_name_text() {
		return user_name_text;
	}
	public void setUser_name_text(String user_name_text) {
		this.user_name_text = user_name_text;
	}
	List<CommentModel> list;
	public List<CommentModel> getList() {
		return list;
	}
	public void setList(List<CommentModel> list) {
		this.list = list;
	}
	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public int getComment_pic() {
		return comment_pic;
	}
	public void setComment_pic(int comment_pic) {
		this.comment_pic = comment_pic;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void getData(){
		list=new ArrayList<CommentModel>();
		CommentModel commentModel;
		for(int i=0;i<5;i++){
			commentModel=new CommentModel();
			commentModel.setComment_name("jom");
			commentModel.setComment_pic(R.drawable.comment_icon);
			commentModel.setComment_text("good very good");
			commentModel.setUser_name("作者：");
			commentModel.setUser_name_text("haha");
			list.add(commentModel);
		}
	}
}
