package com.hotsix.notice;

import java.util.List;

import com.hotsix.notice.NoticeCommentModel;

public interface NoticeDAO {

	// 글목록
	public List<NoticeModel> noticeList();
	
	//글쓰기
	public int noticeWrite(NoticeModel noticeModel);
	
	//상세보기
	public NoticeModel noticeView(int no);
	//글수정(noticeModify)
	public int noticeModify(NoticeModel noticeModel);
	//글삭제
	public int noticeDelete(int no);
	//조회수
	int noticeUpdateReadhit(int no);
	//댓글쓰기
	public boolean noticewritecomment(NoticeCommentModel ncModel);
	
	//댓글리스트
	public List<NoticeCommentModel> noticecommentList(int notice_no);
	
	//댓글삭제
	public boolean noticedeletecomment(int noticecomment_no);
	
	//댓글 총갯수
	public int cmtcount(int notice_no);
	
	//검색
	public List<NoticeModel> noticeSearch0(String search);
	
	public List<NoticeModel> noticeSearch1(String search);

	public List<NoticeModel> noticeList2();


}