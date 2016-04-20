package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;

public class NaoModel {
	private String path;
	private String name;
	private String content;
	private String address;
	private float height = 250;
	private float alph = 0.6f;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float len) {
		this.height = len;
	}

	public float getAlph() {
		return alph;
	}

	public void setAlph(float alph) {
		this.alph = alph;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static List<NaoModel> getData() {
		List<NaoModel> data = new ArrayList<NaoModel>();
		NaoModel model;

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		model.content = "鲜香虾仁炒饭，非常好吃的一个炒饭。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		model.content = "鲜香虾仁炒饭，非常好吃的一个炒饭。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		model.content = "鲜香虾仁炒饭，非常好吃的一个炒饭。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		model.content = "鲜香虾仁炒饭，非常好吃的一个炒饭。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		model.content = "鲜香虾仁炒饭，非常好吃的一个炒饭。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.content = "芝麻千层脆，非常好吃的一个零食。真的好吃，不信你来一口哇？";
		model.address = "重庆";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		return data;
	}
}
