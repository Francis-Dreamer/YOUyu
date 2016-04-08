package com.example.youyu.model;

import java.util.List;

public class YuModel {
	String text_number;
	String text_name;
	String text;
	String weather;
	long time;
	List<YuModel> list;
	public List<YuModel> getList() {
		return list;
	}
	public void setList(List<YuModel> list) {
		this.list = list;
	}
	public String getText_number() {
		return text_number;
	}
	public void setText_number(String text_number) {
		this.text_number = text_number;
	}
	public String getText_name() {
		return text_name;
	}
	public void setText_name(String text_name) {
		this.text_name = text_name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void getData(){
		YuModel model=new YuModel();
		model.setText("是否考虑该好好读书卡还给客户给大家看还是感慨");
		model.setText_name("2016重庆吃货心愿单");
		model.setText_number("一");
		model.setWeather("晴");
	}
}
