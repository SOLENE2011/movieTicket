<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String cp = request.getContextPath(); %>

<script type="text/javascript">
	function openZipcode(joinform){
		var url="zipCheckAction.mt";
		cw=screen.availWidth;     //화면 넓이
		ch=screen.availHeight;    //화면 높이
	
		sw=410;    //띄울 창의 넓이
		sh=400;    //띄울 창의 높이
	
		ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		mt=(ch-sh)/2;        //가운데 띄우기위한 창의 y위치
		window.open(url, "confirm","width="+sw+", height="+sh+",top="+mt+", left="+ml+", toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no");
	}
</script>
<div class="sign_grp">
	<div class="step">
		<ul>
			<li>1. 약관동의</li>
			<li class="on">2. 회원정보입력</li>
			<li>3. 가입완료</li>
		</ul>
	</div>
	<form:form commandName="member" action="memberEnd.mt" method="post" name="joinform">
		<div class="sign_box">
			<p class="tit"><span><img src="<%=cp %>/images/icon/sign_02.png" alt="회원정보입력" /></span>회원정보입력</p>
			<div class="step_02">
				<div class="tbl_type_01">
					<table>
						<caption>아이디,비밀번호,비밀번호확인,이름,주민등록번호,주소,전화번호,이메일,수신확인 작성하는 표</caption>
						<colgroup>
							<col style="width:120px" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">아이디</th>
								<td>
									<form:input type="text" class="txt w200" path="id"  />
									<strong class="pt_red ibk"><form:errors path="id" /></strong>
									<strong class="pt_red ibk"><form:errors element="id" /></strong>
								</td>
							</tr>
							<tr>
								<th scope="row">비밀번호</th>
								<td>
									<form:input type="password" class="txt w200" path="passwd" />
									<strong class="pt_red ibk"><form:errors path="passwd" /></strong>
								</td>
							</tr>
							<tr>
								<th scope="row">비밀번호 확인</th>
								<td>
									<form:input type="password" class="txt w200" path="passwd2"  />
									<strong class="pt_red ibk"><form:errors path="passwd2" /></strong>
								</td>
							</tr>
							<tr>
								<th scope="row">이름</th>
								<td>
									<form:input type="text" class="txt w200" path="name" />
									<strong class="pt_red ibk"><form:errors path="name" /></strong>
								</td>
							</tr>
							<tr>
								<th scope="row">주민번호</th>
								<td>
									<input type="text" class="txt w100" maxlength="6" name="jumin1" />
									<span class="slash"> - </span>
									<input type="password" class="txt w100" maxlength="7" name="jumin2" />
								</td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td>
									<form:input type="text" class="txt w80" path="zipcode" value="${resultMap.zipcode}" readonly="readonly" />
									<span class="ibk btn btnC_03 btnP_03">
										<input type="button" value="우편번호 검색" onclick="openZipcode(this.form)" />
									</span>
									<span class="bk">상세 주소를 추가 기입해 주세요.</span>
									<span class="bk"><form:input type="text" class="txt" path="addr1" value="${resultMap.addr1}" /></span>
								</td>
							</tr>
							<tr>
								<th scope="row">휴대폰</th>
								<td>
									<form:input type="text" class="txt w200" path="phone" maxlength="11"  />
									<span class="ibk">" - " 없이 입력하세요.</span>
								</td>
							</tr>
							<tr>
								<th scope="row">이메일</th>
								<td>
									<form:input type="text" class="txt w200" path="email" />
									<strong class="pt_red ibk"><form:errors path="email" /></strong>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="btn_type_04">
			<a href="member.mt" class="btn btnC_03 btnF_02 mr10">
				<span>취소</span>
			</a>
			<span class="btn btnC_04 btnF_02">
				<input type="submit" value="가입" />
			</span>
		</div>
	</form:form>
</div>