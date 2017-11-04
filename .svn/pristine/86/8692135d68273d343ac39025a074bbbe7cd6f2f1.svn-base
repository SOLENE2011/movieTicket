package com.hotsix.freeboard;

import java.util.List;

public interface FreeBoardDao {
	
	// 글목록
	public List<FreeBoardModel> freeBoardList();
	
	// 글쓰기
	public int freeBoardWrite(FreeBoardModel freeBoardModel);
	
	// 상세 페이지
	public FreeBoardModel freeBoardView(int free_no);
	
	// 조회수 증가
	int freeUpdateReadHit(int free_no);
	
	// 수정
	public int freeBoardModify(FreeBoardModel freeBoardModel);
	
	// 삭제
	public boolean freeBoardDelete(int free_no);
	
	// 검색 ( name = 0, subject = 1)
	List<FreeBoardModel> memberSearch0(String isSearch);
	List<FreeBoardModel> memberSearch1(String isSearch);
	
	
}
