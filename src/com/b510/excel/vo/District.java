package com.b510.excel.vo;

public class District {
	private String id ;
	private String district ;
	private String cityinitials ;
	private String fullpinyin ;
	private String fullnameinitials ;
	private String cityid ;
	private String markid ;
	private String createtime ;
	private String updatetime ;
	private Integer status ;
	private Integer sortno ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCityinitials() {
		return cityinitials;
	}
	public void setCityinitials(String cityinitials) {
		this.cityinitials = cityinitials;
	}
	public String getFullpinyin() {
		return fullpinyin;
	}
	public void setFullpinyin(String fullpinyin) {
		this.fullpinyin = fullpinyin;
	}
	public String getFullnameinitials() {
		return fullnameinitials;
	}
	public void setFullnameinitials(String fullnameinitials) {
		this.fullnameinitials = fullnameinitials;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getMarkid() {
		return markid;
	}
	public void setMarkid(String markid) {
		this.markid = markid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", district=" + district + ", cityinitials=" + cityinitials + ", fullpinyin="
				+ fullpinyin + ", fullnameinitials=" + fullnameinitials + ", cityid=" + cityid + ", markid=" + markid
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", status=" + status + ", sortno="
				+ sortno + "]";
	}
	public District() {
		super();
	}
	
	
}
