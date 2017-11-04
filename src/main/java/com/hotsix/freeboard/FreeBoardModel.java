package com.hotsix.freeboard;

import java.util.Date;

public class FreeBoardModel {
	private int free_no;
	private String name;
	private String subject;
	private String contents;
	private Date reg_date;
	private int read_hit;
	
	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRead_hit() {
		return read_hit;
	}
	public void setRead_hit(int read_hit) {
		this.read_hit = read_hit;
	}
}
