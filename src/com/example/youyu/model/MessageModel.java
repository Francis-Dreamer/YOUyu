package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

public class MessageModel {

	String id;
	String username;
	String source;
	String content;
	String do_what;
	String time;

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDo_what() {
		return do_what;
	}

	public void setDo_what(String do_what) {
		this.do_what = do_what;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public static List<MessageModel> getData(){
		List<MessageModel> data=new ArrayList<MessageModel>();
		MessageModel model;
		for (int i = 0; i < 4 ; i++) {
			model=new MessageModel();
			model.setSource("消息来源测试数据"+i);
			model.setDo_what("回复还是评论了你"+i);
			model.setContent("消息内容测试数据"+i);
			model.setTime("消息时间测试时间"+i);
			data.add(model);
		}
		return data;
	}

}
