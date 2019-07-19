package com.vo;

public class RestaurantVO {
	private int    res_num   =0; 
	private String res_name  =null; 
	private String res_tel   =null; 
	private String res_addr  =null; 
	private int	   res_hate  =0; 
	private int    res_like  =0; 
	private String res_photo =null; 
	private String res_info  =null; 
	private String res_time  =null; 
	private double lat       =0.0; 
	private double lng       =0.0;
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_tel() {
		return res_tel;
	}
	public void setRes_tel(String res_tel) {
		this.res_tel = res_tel;
	}
	public String getRes_addr() {
		return res_addr;
	}
	public void setRes_addr(String res_addr) {
		this.res_addr = res_addr;
	}
	public int getRes_hate() {
		return res_hate;
	}
	public void setRes_hate(int res_hate) {
		this.res_hate = res_hate;
	}
	public int getRes_like() {
		return res_like;
	}
	public void setRes_like(int res_like) {
		this.res_like = res_like;
	}
	public String getRes_photo() {
		return res_photo;
	}
	public void setRes_photo(String res_photo) {
		this.res_photo = res_photo;
	}
	public String getRes_info() {
		return res_info;
	}
	public void setRes_info(String res_info) {
		this.res_info = res_info;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	} 
}
