package com.b510.excel.vo;

public class Province {

	private String id;
	private String name;
	private String markid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarkid() {
		return markid;
	}
	public void setMarkid(String markid) {
		this.markid = markid;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", markid=" + markid + "]";
	}
	public Province() {
		super();
	}
}
