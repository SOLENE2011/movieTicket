package com.hotsix.magazine;

import java.util.List;

import com.hotsix.member.MemberModel;
import com.hotsix.magazine.MagazineCommentModel;

public interface MagazineDAO {
	int getMagazine_NO_SEQ();
	List<MagazineModel> magazineList();
	
	//magazineInsert
	public int magazineWrite(MagazineModel magazineModel);
	
	//magazineView
	MagazineModel magazineView(int magazine_no);
	
	//magazineModify
	boolean magazineUpdate(MagazineModel magazineModel);
	
	//magazineDelete
	boolean magazineDelete(int magazine_no);
	
	//comment
	
	MagazineCommentModel magazineCommentView(String mcomment_no);
	
	public boolean writecomment(MagazineCommentModel mgModel);
	
	public List<MagazineCommentModel> commentList(int origin_no);
	
	public boolean commentDelete(MagazineCommentModel magazineCommentModel);

	public boolean commentUpdate(MagazineCommentModel magazineCommentModel);
	public int cmtcount(int magazine_no);
	
	//search
	List<MagazineModel> magazineSearch0(String search);
	List<MagazineModel> magazineSearch1(String search);
	
	MagazineCommentModel passwordfind(String mcomment_no);
	
	int magazineUpdateReadhit(int magazine_no);
}
