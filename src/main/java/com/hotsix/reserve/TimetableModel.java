package com.hotsix.reserve;

import java.util.Date;

public class TimetableModel {
	int movie_no, room_no, time_no, time_detail_no;  // keys  SCHEDULE_NO
	String movie_name, room_name, time_name, show_date, start_time, end_time; 
	Date start_date, end_date;
	int total_seat, reserved_seat;
	int adult_amt, child_amt;
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
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
	public String getTime_name() {
		return time_name;
	}
	public void setTime_name(String time_name) {
		this.time_name = time_name;
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
	public int getTotal_seat() {
		return total_seat;
	}
	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}
	public int getReserved_seat() {
		return reserved_seat;
	}
	public void setReserved_seat(int reserved_seat) {
		this.reserved_seat = reserved_seat;
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
	
	
}
