package com.hotsix.magazine;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.hotsix.member.MemberModel;

@Service
public class MagazineService implements MagazineDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MagazineModel> magazineList(){
		return sqlSessionTemplate.selectList("magazine.magazineList");
	}
	@Override
	public int getMagazine_NO_SEQ(){
		return sqlSessionTemplate.selectOne("magazine.getMagazine_NO_SEQ");
	}

	@Override
	public int magazineWrite(MagazineModel magazineModel){
		return sqlSessionTemplate.insert("magazine.magazineWrite",magazineModel);
		
	}
	
	@Override
	public MagazineModel magazineView(int magazine_no){
		return sqlSessionTemplate.selectOne("magazine.magazineView",magazine_no);
	}
	
	//magazineModify
	@Override
	public boolean magazineUpdate(MagazineModel magazineModel){
		sqlSessionTemplate.update("magazine.magazineUpdate",magazineModel);
		return true;
	}
	
	//magazineDelete
	@Override
	public boolean magazineDelete(int magazine_no){
		sqlSessionTemplate.update("magazine.magazineDelete",magazine_no);
		return true;
	}
	
	@Override
	public boolean commentDelete(MagazineCommentModel magazineCommentModel){
		sqlSessionTemplate.update("magazine.commentDelete",magazineCommentModel);
		return true;
	}
	
	@Override
	public boolean commentUpdate(MagazineCommentModel magazineCommentModel){
		sqlSessionTemplate.update("magazine.commentUpdate",magazineCommentModel);
		return true;
	}
	
	@Override
	public MagazineCommentModel magazineCommentView(String mcomment_no) {
		return sqlSessionTemplate.selectOne("magazine.magazineCommentView",mcomment_no);
	}
	
	@Override
	public boolean writecomment(MagazineCommentModel mgModel){
		sqlSessionTemplate.insert("magazine.writecomment",mgModel);
		return true;
	}
	
	@Override
	public List<MagazineCommentModel> commentList(int origin_no){
		return sqlSessionTemplate.selectList("magazine.selectcmtAll",origin_no);
	}
	
	@Override
	public int cmtcount(int magazine_no){
		return sqlSessionTemplate.selectOne("magazine.cmtcount",magazine_no);
	}
	
	//search
	public List<MagazineModel> magazineSearch0(String search){
		return sqlSessionTemplate.selectList("magazine.magazineSearch0","%"+search+"%");
	}
	
	public List<MagazineModel> magazineSearch1(String search){
		return sqlSessionTemplate.selectList("magazine.magazineSearch1","%"+search+"%");
	}
	@Override
	public MagazineCommentModel passwordfind(String mcomment_no) {
		return sqlSessionTemplate.selectOne("magazine.passwordfind",mcomment_no);
	}
	
	@Override
	public int magazineUpdateReadhit(int magazine_no){
		return sqlSessionTemplate.update("magazine.magazineUpdateReadhit",magazine_no);
	}
	
}
