package com.hotsix.mypage;

import java.util.Date;

/**
 * 예매 상세보기에서 사용할 데이터 모델
 * @author user1
 *
 */
public class MypageModel3 {
	
	private String reserve_master_no;
	private String adult;
	private String child;
	private String total_amount;
	
	public String getReserve_master_no() {
		return reserve_master_no;
	}
	public void setReserve_master_no(String reserve_master_no) {
		this.reserve_master_no = reserve_master_no;
	}
	
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	

}
	
	