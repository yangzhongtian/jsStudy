package com.terren;

public class NewsLog {
	private String time; //时间
	private String Ip;   //ip地址
	private String cookie; //cookie
	private String visitType;// 0:新访 and 1:回访  
	private String url; //url and meta
	private String refer;//引用
	private String  length;
	private String  title;//标题utf-8
	private String  codeing;
	private  String  collected;//是否被收藏
	private  String vTime;  //vtype时间
	private  String ua;  //userAgent
	private  String showType;
	private  String area;
	private  String  other;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		Ip = ip;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCodeing() {
		return codeing;
	}
	public void setCodeing(String codeing) {
		this.codeing = codeing;
	}
	public String getvTime() {
		return vTime;
	}
	public String getVisitType() {
		return visitType;
	}
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
	public String getCollected() {
		return collected;
	}
	public void setCollected(String collected) {
		this.collected = collected;
	}
	public void setvTime(String vTime) {
		this.vTime = vTime;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	public NewsLog() {
		// TODO Auto-generated constructor stub
	}
}
