package com.hotsix.admin;

import java.util.Date;

public class TimeTableListModel {
	private int time_no;
	private int time_detail_no;
	private int movie_no;
	private int reserved_seat;
	private int total_seat;
	private int adult_amt;
	private int child_amt;
	private String movie_name;
	private String room_name;
	private String show_date;
	private String start_time;
	private String end_time;
	private Date start_date;
	private Date end_date;
	
	public int getTime_no() {
		return time_no;
	}
	public void setTime_no(int time_no) {
		this.time_no = time_no;
	}
	public int getTime_detail_no() {
		return time_detail_no;
	}
	public void setTime_detail_no(int time_detail_no) {
		this.time_detail_no = time_detail_no;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public int getReserved_seat() {
		return reserved_seat;
	}
	public void setReserved_seat(int reserved_seat) {
		this.reserved_seat = reserved_seat;
	}
	public int getTotal_seat() {
		return total_seat;
	}
	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}
	public int getAdult_amt() {
		return adult_amt;
	}
	public void setAdult_amt(int adult_amt) {
		this.adult_amt = adult_amt;
	}
	public int getChild_amt() {
		return child_amt;
	}
	public void setChild_amt(int child_amt) {
		this.child_amt = child_amt;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getShow_date() {
		return show_date;
	}
	public void setShow_date(String show_date) {
		this.show_date = show_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
}
