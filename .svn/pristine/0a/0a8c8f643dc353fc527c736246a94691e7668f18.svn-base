package com.hotsix.member;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements MemberDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	// 로그인 체크
	@Override
	public MemberModel memberLogin(MemberModel member) {
		return sqlSessionTemplate.selectOne("member.login", member);
	}

	// 회원정보 입력
	@Override
	public Object insertMember(MemberModel member) {
		return sqlSessionTemplate.insert("member.insertMember", member);
	}

	// 이름으로 비밀번호와 아이디 찾기
	@Override
	public MemberModel idFindByName(MemberModel member) {
		return sqlSessionTemplate.selectOne("member.idfind", member);
	}

	// 회원수정
	@Override
	public Object memberModify(MemberModel member) {
		return sqlSessionTemplate.update("member.updateMember", member);
	}
	
	// 아이디 찾기
	@Override
	public MemberModel getMember(String id) {
		return sqlSessionTemplate.selectOne("member.getMember", id);
	}
		
	// 회원탈퇴
	@Override
	public Object memberDelete(String id) {
		return sqlSessionTemplate.delete("member.deleteMember", id);
	}

	// 우편번호
	@Override
	public List<ZipcodeModel> zipCheckAction(String dong) {
		return sqlSessionTemplate.selectList("member.zipSearch",dong);
	}
}
