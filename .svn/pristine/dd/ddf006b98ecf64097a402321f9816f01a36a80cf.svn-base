<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>

<div class="logo">
	<h1><a href="<%=cp %>/main.mt">MovieTicket</a></h1>
</div>
<div class="util_menu">
	<div class="inner">
		<ul>
			<c:if test="${session_member_name == null }">
			<li><a href="<%=cp %>/member/member.mt">회원가입</a></li>
			<li><a href="<%=cp %>/member/login.mt">로그인</a></li>
			<li><a href="<%=cp %>/member/memberIdFind.mt">아이디&#47;비번찾기찾기</a></li>
			<li><a href="<%=cp %>/free/freeBoardList.mt">자유게시판</a></li>
			</c:if>
			
			<!-- 일반로그인 -->
			<c:if test="${session_member_grade == 0}">
			<li class="name">${session_member_name} 님</li>
			<li>
				<a href="<%=cp %>/member/logout.mt" class="logoutConfirm">로그아웃</a>
			</li>
			</c:if>
			
			<!-- 관리자로그인 -->
			<c:if test="${session_member_grade == 1}">
			<li class="admin"><a href="<%=cp %>/admin/movieList.mt">${session_member_name} 님</a></li>
			<li><a href="<%=cp %>/member/logout.mt">로그아웃</a></li>
			</c:if>
		</ul>
	</div>
</div>