package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

public class EatWishModel {
	String wish_iconName;
	String wish_signature;
	String wish_iconpic;
	String wish_title;
	String wish_english_title;
	String wish_text;
	List<EatWishModel> list;
	String wish_address;
	public String getWish_address() {
		return wish_address;
	}
	public void setWish_address(String wish_address) {
		this.wish_address = wish_address;
	}
	public List<EatWishModel> getList() {
		return list;
	}
	public void setList(List<EatWishModel> list) {
		this.list = list;
	}
	public String getWish_iconName() {
		return wish_iconName;
	}
	public void setWish_iconName(String wish_iconName) {
		this.wish_iconName = wish_iconName;
	}
	public String getWish_signature() {
		return wish_signature;
	}
	public void setWish_signature(String wish_signature) {
		this.wish_signature = wish_signature;
	}
	public String getWish_iconpic() {
		return wish_iconpic;
	}
	public void setWish_iconpic(String wish_iconpic) {
		this.wish_iconpic = wish_iconpic;
	}
	public String getWish_title() {
		return wish_title;
	}
	public void setWish_title(String wish_title) {
		this.wish_title = wish_title;
	}
	public String getWish_english_title() {
		return wish_english_title;
	}
	public void setWish_english_title(String wish_english_title) {
		this.wish_english_title = wish_english_title;
	}
	public String getWish_text() {
		return wish_text;
	}
	public void setWish_text(String wish_text) {
		this.wish_text = wish_text;
	}
	public void getData(){
		list=new ArrayList<EatWishModel>();
		EatWishModel eatWishModel;
		for(int i=0;i<2;i++){
			eatWishModel=new EatWishModel();
			eatWishModel.setWish_title("一花一叶·禅宗素食");
			eatWishModel.setWish_english_title("VEGETARIAN DETS");
			eatWishModel.setWish_text("现在是不是捏着肚子上的肉肉发愁。莫慌，整一顿素餐吧。");
			eatWishModel.setWish_address("重庆");
			list.add(eatWishModel);
		}
	}
}
