package com.duchunxia.vo;

import java.util.List;

public class SeriesBean {

	String name;
	String  type;
	List<String> data ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public SeriesBean(String name, String type, List<String> data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}

}
