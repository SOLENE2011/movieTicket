package com.hotsix.admin;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.hotsix.member.MemberModel;
import com.hotsix.movie.MovieModel;
import com.hotsix.reserve.RoomModel;
import com.hotsix.reserve.TimetableDetailModel;
import com.hotsix.reserve.TimetableMasterModel;

@Service
public class AdminService implements AdminDAO{

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MemberModel> memberList() {
		return sqlSessionTemplate.selectList("member.memberList");
	}
	
	@Override
	public List<MemberModel> memberSearch0(String isSearch) {
		return sqlSessionTemplate.selectList("admin.memberSearch0", "%"+isSearch+"%");
	}
	@Override
	public List<MemberModel> memberSearch1(String isSearch) {
		return sqlSessionTemplate.selectList("admin.memberSearch1", "%"+isSearch+"%");
	}
	@Override
	public List<MemberModel> memberSearch2(String isSearch) {
		return sqlSessionTemplate.selectList("admin.memberSearch2", "%"+isSearch+"%");
	}

	@Override
	public int getMovieSEQ() {
		return sqlSessionTemplate.selectOne("admin.getMovieSEQ");
	}



	@Override
	public List<RoomModel> timeRoom() {
		return sqlSessionTemplate.selectList("admin.timeRoom");
	}

	@Override
	public List<TimeTableListModel> timeList() {
		return sqlSessionTemplate.selectList("admin.timeTableList");
	}
	
	@Override
	public boolean timeMasterInsert(TimetableMasterModel masterModel) {
		sqlSessionTemplate.insert("admin.timeMasterInsert",masterModel);
		return true;
	}

	@Override
	public List<AdminModel> timeMovie() {
		return sqlSessionTemplate.selectList("admin.timeMovie");
	}

	@Override
	public boolean timeDetailInsert(TimetableDetailModel detailModel) {
		sqlSessionTemplate.insert("admin.timeDetailInsert", detailModel);
		return true;
	}

	@Override
	public boolean timeMasterDelete(int time_no) {
		sqlSessionTemplate.delete("admin.timeMasterDelete", time_no);
		return true;
	}

	@Override
	public boolean timeDetailDelete(int time_detail_no) {
		sqlSessionTemplate.delete("admin.timeDetailDelete", time_detail_no);
		return true;
	}
	
}
