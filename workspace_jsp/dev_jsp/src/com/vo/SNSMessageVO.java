package com.vo;

public class SNSMessageVO {
	private int    mno      =0; 
	private String mem_id   =null; 
	private String msg      =null; 
	private String favcount =null; 
	private String msg_date =null;
	// 댓글 갯수
	private int replycount;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFavcount() {
		return favcount;
	}
	public void setFavcount(String favcount) {
		this.favcount = favcount;
	}
	public String getMsg_date() {
		return msg_date;
	}
	public void setMsg_date(String msg_date) {
		this.msg_date = msg_date;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	} 
}
