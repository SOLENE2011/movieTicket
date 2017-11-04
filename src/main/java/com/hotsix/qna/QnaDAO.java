package com.hotsix.qna;

import java.util.List;

public interface QnaDAO {

	//湲�紐⑸줉
	List<QnaModel> qnaList();
	
	//湲��벐湲�
	int qnaWrite(QnaModel qnaModel);
	
	//�떟蹂�湲��벐湲�
	int qnaWriteReply(QnaModel qnaModel);
	
	//湲��긽�꽭蹂닿린
	QnaModel qnaView(int qna_no);
	
	//議고쉶�닔利앷�
	int qnaUpdateReadhit(int qna_no);
	
	//寃��깋 (0=�젣紐�, 1=�궡�슜, 2=�씠由�)
	List<QnaModel> qnaSearch0(String search);
	List<QnaModel> qnaSearch1(String search);
	List<QnaModel> qnaSearch2(String search);

	//湲��닔�젙
	int qnaModify(QnaModel qnaModel);
	//int qnaModify(int qna_no);
	
	//湲��궘�젣
	int qnaDelete(int qna_no);
	
	int qnaDelete2(int ref);
}	
	
	
	/*QnaModel qnaView2 (int qna_no);*/
	
	
