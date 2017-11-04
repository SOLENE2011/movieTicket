<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String cp = request.getContextPath(); %>
<script type="text/javascript">
	function openZipcode(joinform){
		var url="<%=cp %>/member/zipCheckAction.mt";
		cw=screen.availWidth;     //화면 넓이
		ch=screen.availHeight;    //화면 높이
	
		sw=410;    //띄울 창의 넓이
		sh=400;    //띄울 창의 높이
	
		ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		mt=(ch-sh)/2;        //가운데 띄우기위한 창의 y위치
		window.open(url, "confirm","width="+sw+", height="+sh+",top="+mt+", left="+ml+", toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no");
	}
	
	function check(){
		var f = document.memberModifyForm;
		
		if(f.passwd.value == ""){
			alert("비밀번호를 입력하세요");
			f.passwd.focus();
			return false;
		}else if((f.name.value == "") || (f.name.value.length <= 1)){
			alert("이름을 제대로 입력해 주세요");
			f.name.focus();
			return false;
		}else if(f.id.value == ""){
			alert("아이디를 입력하세요");
			f.id.focus();
			return false;
		}else if(f.passwd.value != f.passwd2.value){
			alert("비밀번호가 일치하지 않습니다");
			f.passwd.value = "";
			f.passwd2.value = "";
			f.passwd.focus();
			return false;
		}else if(f.email.value == ""){
			alert("이메일을 제대로 입력해주세요");
			f.email.focus();
			return false;
		}else if(f.phone.value == ""){
			alert("휴대폰 번호를 입력하세요");
			f.phone.focus();
			return false;
		}
		return true;
	} 
</script>

<div class="mypage_grp">
	<div class="mypage_list">
		<ul>
			<li class="on"><a href="<%=cp%>/mypage/memberModify.mt">회원정보수정</a></li>
			<li><a href="<%=cp%>/mypage/reserveList.mt">예매내역</a></li>
			<li><a href="<%=cp%>/mypage/cancelList.mt">취소내역</a></li>
			<li><a href="<%=cp%>/mypage/wishList.mt">위시리스트</a></li>
			<li><a href="<%=cp %>/mypage/mcoinPage.mt">M_COIN</a></li>
		</ul>
	</div>
	<div class="mypage_ct">
		<form action="<%=cp %>/member/memberModify.mt" method="post" name="memberModifyForm" onsubmit="return check()">
			<div class="tbl_type_01">
				<table>
					<caption>아이디,비밀번호,비밀번호확인,이름,주민등록번호,생년월일,주소,전화번호,이메일,수신확인 수정하는 표</caption>
					<colgroup>
						<col style="width:120px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">아이디</th>
							<td>
								${member.id}
								<input type="hidden" name="id" value="${member.id}" />
							</td>
						</tr>
						<tr>
							<th scope="row">비밀번호</th>
							<td>
								<input type="password" class="txt w200" name="passwd" />
								<span class="bk pt_red">현재 사용중인 비밀번호를 입력하셔야 수정됩니다.</span>
							</td>
						</tr>
						<tr>
							<th scope="row">비밀번호 확인</th>
							<td><input type="password" class="txt w200" name="passwd2" /></td>
						</tr>
						<tr>
							<th scope="row">이름</th>
							<td>
								${member.name}
								<input type="hidden" class="txt w200" name="name" value="${member.name}" />
							</td>
						</tr>
						<tr>
							<th scope="row">주민번호</th>
							<td>
								<input type="text" class="txt w100" maxlength="6" name="jumin1" value="${member.jumin1}" />
								<span class="slash"> - </span>
								<input type="password" class="txt w100" maxlength="7" name="jumin2" value="${member.jumin2}" />
							</td>
						</tr>
						<tr>
							<th scope="row">주소</th>
							<td>
								<input type="text" class="txt w80" id="zipcode" name="zipcode" value="${member.zipcode}" readonly="readonly" />
								<span class="ibk btn btnC_03 btnP_03">
									<input type="button" value="우편번호 검색" onclick="openZipcode(this.form)" />
								</span>
								<span class="bk">상세 주소를 추가 기입해 주세요.</span>
								<span class="bk"><input type="text" class="txt" id="addr1" name="addr1" value="${member.addr1}" /></span>
							</td>
						</tr>
						<tr>
							<th scope="row">휴대폰</th>
							<td>
								<input type="text" class="txt w200" name="phone" value="${member.phone}" maxlength="11" />
								<span class="ibk">" - " 없이 입력하세요.</span>
							</td>
						</tr>
						<tr>
							<th scope="row">이메일</th>
							<td><input type="text" class="txt w200" name="email" value="${member.email}" /></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="btn_type_06">
				<a href="<%=cp %>/member/memberWith.mt" class="btn btnC_03 btnF_02 mr10">
					<span>탈퇴</span>
				</a>
			</div>

			<div class="btn_type_04">
				<a href="<%=cp %>/main.mt" class="btn btnC_03 btnF_02 mr10">
					<span>취소</span>
				</a>
				<span class="btn btnC_04 btnF_02">
					<input type="submit" value="확인" />
				</span>
			</div>
		</form>
	</div>
</div>