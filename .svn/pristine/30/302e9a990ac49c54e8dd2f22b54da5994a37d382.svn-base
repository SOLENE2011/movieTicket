<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li class="on"><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<h3 class="sub_tit">회원정보</h3>
		<div class="tbl_type_02">
			<table>
				<caption>가입한 회원정보 테이블</caption>
				<colgroup>
					<col style="width:7%;" />
					<col style="width:7%;" />
					<col style="width:10%;" />
					<col style="width:8%;" />
					<col style="width:15%;" />
					<col />
					<col style="width:15%;" />
					<col style="width:15%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">회원번호</th>
						<th scope="col">아이디</th>
						<th scope="col">비밀번호</th>
						<th scope="col">이름</th>
						<th scope="col">주민번호</th>
						<th scope="col">주소</th>
						<th scope="col">휴대폰</th>
						<th scope="col">이메일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberlist}">
					<tr>
						<td>${member.member_no}</td>
						<td>${member.id}</td>
						<td>${member.passwd}</td>
						<td>${member.name}</td>
						<td>${member.jumin1}-${member.jumin2}</td>
						<td>${member.addr1}</td>
						<td>${member.phone}</td>
						<td>${member.email}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<!-- 검색 -->
		<div class="search_form">
			<form>
				<fieldset>
					<legend>게시판 검색폼</legend>
					<div class="inner">
						<select class="slct w100" name="searchNum">
							<option value="0">아이디</option>
							<option value="1">이름</option>
							<option value="2">이메일</option>
						</select>
						<input type="text" class="txt w100" name="isSearch" maxlength="20">
						<span class="btn btnC_04 btnP_04">
							<input type="submit" value="검색" />
						</span>
					</div>
				</fieldset>
			</form>
		</div>
		
		<!-- 페이징 -->
		<div class="paging">
			${pagingHtml}
		</div>
	</div>
</div>