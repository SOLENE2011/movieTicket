package com.hotsix.reserve;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.hotsix.member.MemberModel;
import com.hotsix.movie.MovieModel;


@Service
public class ReserveService implements ReserveDAO {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<MovieModel> getTimeMovieData() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("reserve.timeMovieData");
	}

	@Override
	public List<TimetableModel> getCurrentScreeningMovie() {
		return sqlSessionTemplate.selectList("reserve.currMovie");
	}
	
	@Override
	public List<TimetableModel> getTimeList(TimetableModel timetableModel) {
		return sqlSessionTemplate.selectList("reserve.TimeList", timetableModel);
	}
	
	@Override
	public List<TimetableModel> getPlaydates(int movie_no) {
		return sqlSessionTemplate.selectList("reserve.playdates", movie_no);
	}
	
	@Override
	public List<?> getTimeRoomData() {
		return sqlSessionTemplate.selectList("reserve.timeRoomData");
	}
	
	@Override
	public List<?> getTimeSeatData(SeatModel seatModel) {
		return sqlSessionTemplate.selectList("reserve.timeSeatData", seatModel);
	}
	
	@Override
	public List<TimetableDetailModel> getTimeDetailList(int time_detail_no) {
		return sqlSessionTemplate.selectList("reserve.timeDetailOne", time_detail_no);
	}
	
	@Override
	public String getReserveDetailNo() {
		return sqlSessionTemplate.selectOne("reserve.getReserveDetailNo"); 
	}
	
	
	//insert
	@Override
	public void insertReserveMaster(ReserveMasterModel reserveM) {
		sqlSessionTemplate.insert("reserve.reserveMasterInsert", reserveM);
	}
	
	@Override
	public void insertReserveDetail(ReserveDetailModel reserveD) {
		sqlSessionTemplate.update("reserve.reserveDetailInsert", reserveD);
	}
	
	
	
	//update
	@Override
	public void updateTorrentcoin(MemberModel memberM) {
		sqlSessionTemplate.update("reserve.torrentcoinUpdate", memberM);
	}
	
	@Override
	public void updateTimeDetailSeat(int time_detail_no) {
		sqlSessionTemplate.update("reserve.timeDetailSeatUpdate", time_detail_no);
	}
}
