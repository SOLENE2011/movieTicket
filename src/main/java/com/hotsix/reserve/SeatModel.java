package com.hotsix.reserve;

public class SeatModel {
	int seat_no;
	int room_no;
	String seat_name;
	int seat_position;
	int reserved;
	
	public int getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getSeat_name() {
		return seat_name;
	}
	public void setSeat_name(String seat_name) {
		this.seat_name = seat_name;
	}
	public int getSeat_position() {
		return seat_position;
	}
	public void setSeat_position(int seat_position) {
		this.seat_position = seat_position;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
}
