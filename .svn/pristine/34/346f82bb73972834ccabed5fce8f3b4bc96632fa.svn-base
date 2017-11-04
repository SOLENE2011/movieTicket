package com.hotsix.event;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.hotsix.event.EventDAO;
import com.hotsix.event.EventModel;

@Service
public class EventService implements EventDAO{
	
	//공통으로 쓰는 부분
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	//글목록
	@Override
	public List<EventModel> eventList() {
		return sqlSessionTemplate.selectList("event.eventList");
	}
	//글쓰기
	@Override
	public int eventWrite(EventModel eventModel) {
		return sqlSessionTemplate.insert("event.eventWrite", eventModel);
	}
	
	//이벤트이름 번호 리스트 뽑아오기(파일업로드에 쓰임)
	@Override
	public int getEventSEQ() {
		return sqlSessionTemplate.selectOne("event.getEventSEQ");
	}
	
	//상세보기
	@Override
	public EventModel eventView(int event_no) {
		return sqlSessionTemplate.selectOne("event.eventView", event_no);
	}
	
	//글 수정
	@Override
	public int eventUpdate(EventModel eventModel) {
		return sqlSessionTemplate.update("event.eventUpdate", eventModel);
	}
	
	//글 삭제
	@Override
	public int eventDelete(int event_no) {
		return sqlSessionTemplate.update("event.eventDelete", event_no);
	}
	
	//검색
	@Override
	public List<EventModel> eventSearch0(String search) {
		return sqlSessionTemplate.selectList("event.eventSearch0", "%"+search+"%");
	}
	@Override
	public List<EventModel> eventSearch1(String search) {
		return sqlSessionTemplate.selectList("event.eventSearch1", "%"+search+"%");
	}

}
