package com.hotsix.qna;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class QnaService implements QnaDAO{

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<QnaModel> qnaList(){
		return sqlSessionTemplate.selectList("qna.qnaList");
	}
	
	@Override
	public int qnaWrite(QnaModel qnaModel) {
		return sqlSessionTemplate.insert("qna.qnaWrite", qnaModel);
	}
	
	@Override
	public QnaModel qnaView(int qna_no) {
		return sqlSessionTemplate.selectOne("qna.qnaView", qna_no); 
	}

	@Override
	public int qnaUpdateReadhit(int qna_no) {
		return sqlSessionTemplate.update("qna.qnaUpdateReadhit", qna_no);
	}

	@Override
	public int qnaDelete(int qna_no) {
		return sqlSessionTemplate.update("qna.qnaDelete", qna_no);
	}

	@Override
	public int qnaModify(QnaModel qnaModel) {
		return sqlSessionTemplate.update("qna.qnaModify",qnaModel); 
	}
	
	@Override
	public int qnaWriteReply(QnaModel qnaModel) {
		return sqlSessionTemplate.insert("qna.qnaWriteReply", qnaModel);
	}
	
	@Override
	public List<QnaModel> qnaSearch0(String search) {
		return sqlSessionTemplate.selectList("qna.qnaSearch0", "%"+search+"%"); 
	}
	
	@Override
	public List<QnaModel> qnaSearch1(String search) {
		return sqlSessionTemplate.selectList("qna.qnaSearch1", "%"+search+"%"); 
	}
	
	@Override
	public List<QnaModel> qnaSearch2(String search) {
		return sqlSessionTemplate.selectList("qna.qnaSearch2", "%"+search+"%"); 
	}

	@Override
	public int qnaDelete2(int ref) {
		return sqlSessionTemplate.update("qna.qnaDelete2", ref);
	}
}
