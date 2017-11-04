package com.hotsix.freeboard;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService implements FreeBoardDao{

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<FreeBoardModel> freeBoardList() {
		return sqlSessionTemplate.selectList("free.freeList");
	}

	@Override
	public int freeBoardWrite(FreeBoardModel freeBoardModel) {
		return sqlSessionTemplate.insert("free.freeWrite", freeBoardModel);
	}

	@Override
	public FreeBoardModel freeBoardView(int free_no) {
		return sqlSessionTemplate.selectOne("free.freeView", free_no);
	}

	@Override
	public int freeUpdateReadHit(int free_no) {
		return sqlSessionTemplate.update("free.freeUpdateReadHit", free_no);
	}

	@Override
	public int freeBoardModify(FreeBoardModel freeBoardModel) {
		return sqlSessionTemplate.update("free.freeUpdate", freeBoardModel);
	}

	@Override
	public boolean freeBoardDelete(int free_no) {
		sqlSessionTemplate.update("free.freeDelete", free_no);
		return true;
	}

	@Override
	public List<FreeBoardModel> memberSearch0(String isSearch) {
		return sqlSessionTemplate.selectList("free.memberSearch0", "%"+isSearch+"%");
	}

	@Override
	public List<FreeBoardModel> memberSearch1(String isSearch) {
		return sqlSessionTemplate.selectList("free.memberSearch1", "%"+isSearch+"%");
	}
}
