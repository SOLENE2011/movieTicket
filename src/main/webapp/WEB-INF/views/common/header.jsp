<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<script type="text/javascript">
	function logout(){
		var logout = document.getElementById("logout");
		var check = confirm("로그아웃 하시겠습니까?");
		if(check){
			logout.method = "post";
			logout.action = "<%=cp %>/member/logout.mt";
			logout.submit();
			return true;
		}else{
			return false;
		}
	}
</script>
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
				<form id="logout">
					<a href="#none" onclick="logout()">로그아웃</a>
				</form>
			</li>
			<li><a href="<%=cp %>/mypage/memberModify.mt">마이페이지</a></li>
			<li><a href="<%=cp %>/free/freeBoardList.mt">자유게시판</a></li>
			</c:if>
			
			<!-- 관리자로그인 -->
			<c:if test="${session_member_grade == 1}">
			<li class="admin"><a href="<%=cp %>/admin/movieList.mt">${session_member_name} 님</a></li>
			<li>
				<form id="logout">
					<a href="#none" onclick="logout()">로그아웃</a>
				</form>
			</li>
			<li><a href="<%=cp %>/free/freeBoardList.mt">자유게시판</a></li>
			</c:if>
		</ul>
	</div>
</div>
<div class="gnb">
	<ul>
		<li><a href="<%=cp %>/reserve/reserveMain.mt">예매</a></li>
		<li><a href="<%=cp %>/movie/movieList.mt">상영작</a></li>
		<li><a href="<%=cp %>/magazine/magazineList.mt">매거진</a></li>
		<li><a href="<%=cp %>/event/eventList.mt">이벤트</a></li>
	</ul>
</div>
