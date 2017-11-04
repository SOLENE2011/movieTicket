package com.hotsix.admin;

import java.util.List;

import com.hotsix.member.MemberModel;
import com.hotsix.reserve.RoomModel;
import com.hotsix.reserve.TimetableDetailModel;
import com.hotsix.reserve.TimetableMasterModel;

public interface AdminDAO {
	
	// 회원정보
	List<MemberModel> memberList();
	
	// (0 = id, 1 = name, 2 = email) 
	List<MemberModel> memberSearch0(String isSearch);
	List<MemberModel> memberSearch1(String isSearch);
	List<MemberModel> memberSearch2(String isSearch);
	
	// 상영작리스트
	List<TimeTableListModel> timeList();
	
	// 룸 정보
	List<RoomModel> timeRoom();
	
	// timeMovieList
	List<AdminModel> timeMovie();
	
	int getMovieSEQ();
	
	// timeMasterInsert
	boolean timeMasterInsert(TimetableMasterModel masterModel);
	
	// timeDetailInsert
	boolean timeDetailInsert(TimetableDetailModel detailModel);
	
	// timeMasterDelete
	boolean timeMasterDelete(int time_no);
	
	// timeDetailDelete
	boolean timeDetailDelete(int time_detail_no);
}
