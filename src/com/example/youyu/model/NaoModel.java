package com.example.youyu.model;

import java.util.ArrayList;
import java.util.List;

import com.example.youyu.R;

public class NaoModel {
	private String path;
	private String name;

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

	public static List<NaoModel> getData() {
		List<NaoModel> data = new ArrayList<NaoModel>();
		NaoModel model;

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);
		
		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);
		
		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);
		
		model = new NaoModel();
		model.name = "鲜香虾仁炒饭";
		model.path = R.drawable.nao_item1 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "芝麻千层脆";
		model.path = R.drawable.nao_item2 + "";
		data.add(model);

		model = new NaoModel();
		model.name = "哇，你看起来好辣";
		model.path = R.drawable.nao_item3 + "";
		data.add(model);
		
		return data;
	}
}
