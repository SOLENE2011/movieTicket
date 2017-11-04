package com.hotsix.reserve;

import java.util.List;

import com.hotsix.member.MemberModel;
import com.hotsix.movie.MovieModel;


public interface ReserveDAO {

	List<MovieModel> getTimeMovieData();
	List<TimetableModel> getCurrentScreeningMovie();
	List<TimetableModel> getTimeList(TimetableModel timetableModel);
	List<TimetableModel> getPlaydates(int movie_no);
	List<?> getTimeRoomData();
	List<?> getTimeSeatData(SeatModel seatModel);
	List<TimetableDetailModel> getTimeDetailList(int time_detail_no);
	String getReserveDetailNo();
	void insertReserveMaster(ReserveMasterModel reserveM);
	void updateTorrentcoin(MemberModel memberM);
	void insertReserveDetail(ReserveDetailModel reserveD);
	void updateTimeDetailSeat(int time_detail_no);
}
