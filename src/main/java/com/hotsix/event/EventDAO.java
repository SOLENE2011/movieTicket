package com.hotsix.event;

import java.util.List;

public interface EventDAO {
	
	//글목록
	public List<EventModel> eventList();
	
	//이벤트이름 번호 리스트 뽑아오기(파일 업로드에 쓰임)
	public int getEventSEQ();
	
	//글쓰기
	public int eventWrite(EventModel eventModel);
	
	//상세보기
	public EventModel eventView(int event_no);
	
	//글 수정(eventupdate)
	public int eventUpdate(EventModel eventModel);
	
	//글삭제
	public int eventDelete(int event_no);
	
	//검색
	public List<EventModel> eventSearch0(String search);
	
	public List<EventModel> eventSearch1(String search);

}
