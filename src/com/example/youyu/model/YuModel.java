package com.example.youyu.model;

import java.util.ArrayList;
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

	public void getData() {
		list=new ArrayList<YuModel>();
		YuModel yuModel;
			yuModel = new YuModel();
			yuModel.setText("发给骄傲的开工建设卡号给看了啥了");
			yuModel.setText_name("2016重庆吃货心愿单");
			yuModel.setText_number("一");
			yuModel.setWeather("晴");
			list.add(yuModel);
			yuModel = new YuModel();
			yuModel.setText("搞定了；接啊感觉啊结果的结果的时间");
			yuModel.setText_name("2016重庆吃货心愿单");
			yuModel.setText_number("二");
			yuModel.setWeather("雷震雨");
			list.add(yuModel);
			yuModel = new YuModel();
			yuModel.setText("好看啦放假好卡激活空间上看哈噶快乐很快乐");
			yuModel.setText_name("2016重庆吃货心愿单");
			yuModel.setText_number("三");
			yuModel.setWeather("大雨");
			list.add(yuModel);
			yuModel = new YuModel();
			yuModel.setText("是否考虑该好好读书卡还给客户给大家看还是感慨");
			yuModel.setText_name("2016重庆吃货心愿单");
			yuModel.setText_number("四");
			yuModel.setWeather("小雨");
			list.add(yuModel);
			yuModel = new YuModel();
			yuModel.setText("是否考虑该好好读书卡还给客户给大家看还是感慨");
			yuModel.setText_name("2016重庆吃货心愿单");
			yuModel.setText_number("五");
			yuModel.setWeather("晴转多云");
			list.add(yuModel);
		}

}
