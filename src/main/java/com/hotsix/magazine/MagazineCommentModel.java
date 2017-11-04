package com.hotsix.magazine;

import java.util.Date;

public class MagazineCommentModel {
	private int mcomment_no;
	private int origin_no;
	private String name;
	private String password;
	private String content;
	private Date reg_date;
	
	public int getMcomment_no() {
		return mcomment_no;
	}
	public void setMcomment_no(int mcomment_no) {
		this.mcomment_no = mcomment_no;
	}
	public int getOrigin_no() {
		return origin_no;
	}
	public void setOrigin_no(int origin_no) {
		this.origin_no = origin_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}