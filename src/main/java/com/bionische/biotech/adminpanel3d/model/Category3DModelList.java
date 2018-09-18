package com.bionische.biotech.adminpanel3d.model;

import java.util.List;

public class Category3DModelList {
	
	List<Category3DModel> category3DModelList;
	
	Info info;

	public List<Category3DModel> getCategory3DModelList() {
		return category3DModelList;
	}

	public void setCategory3DModelList(List<Category3DModel> category3dModelList) {
		category3DModelList = category3dModelList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Category3DModelList [category3DModelList=" + category3DModelList + ", info=" + info + "]";
	}
	
	

}
