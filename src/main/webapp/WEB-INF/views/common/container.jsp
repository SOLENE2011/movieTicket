<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- main_vis -->
<div class="main_vis">
	<div class="rolling">
		<div id="owl-demo" class="owl-carousel owl-theme">
			<div class="item"><img src="<%= cp %>/images/roll1.jpg"></div>
			<div class="item"><img src="<%= cp %>/images/roll2.jpg"></div>
			<div class="item"><img src="<%= cp %>/images/roll3.jpg"></div>
		</div>
	</div>
	<div class="main_login">
		<!-- 비로그인 -->
		<c:if test="${session_member_name == null }">
		<form action="<%=cp %>/member/login.mt" method="post" >
			<fieldset>
				<legend>로그인</legend>
				<div class="login_box">
					<div class="inner">
						<div class="input_box">
							<label for="id" class="lbl_txt">ID</label>
							<input type="text" class="txt" id="id" name="id" placeholder="ID" />
						</div>
						<div class="input_box">
							<label for="pw" class="lbl_txt">PW</label>
							<input type="password" class="txt" id="pw" name="passwd" placeholder="PW" />
						</div>
						<input type="submit" value="로그인" class="btn_login" />
					</div>
				</div>
				<div class="login_btm">
					<ul>
						<li class="m1"><a href="<%=cp %>/member/member.mt">회원가입</a></li>
						<li class="m2">
							<a href="<%=cp %>/member/memberIdFind.mt">아이디  &#47; 비밀번호 찾기</a>
						</li>
					</ul>
				</div>
			</fieldset>
		</form>
		</c:if>
		<!-- 일반로그인 -->
		<c:if test="${session_member_grade == 0}">
		<div class="login_ok">
			<p class="name"><strong>${session_member_name}</strong>님 환영합니다.</p>
			<div class="btn_login_ok">
				<form id="logout" class="mr10 inblock">
					<a href="#none" onclick="logout()" class="btn btnC_02 btnF_03">
						<span>로그아웃</span>
					</a>
				</form>
				<a href="<%=cp %>/mypage/memberModify.mt" class="btn btnC_02 btnF_03">
					<span>정보수정</span>
				</a>
			</div>
		</div>
		</c:if>
		<!-- 관리자 로그인 -->
		<c:if test="${session_member_grade == 1}">
		<div class="login_ok">
			<p class="name"><strong>${session_member_name}</strong>님 환영합니다.</p>
			<div class="btn_login_ok">
				<form id="logout" class="mr10 inblock">
					<a href="#none" onclick="logout()" class="btn btnC_02 btnF_03">
						<span>로그아웃</span>
					</a>
				</form>
				<a href="<%=cp %>/admin/movieList.mt" class="btn btnC_01 btnF_04">
					<span>관리자</span>
				</a>
			</div>
		</div>
		</c:if>
		<a href="<%= cp %>/reserve/reserveMain.mt" class="btn btnC_01 btnA_01 reserve">
			<span>예매하기</span>
		</a>
	</div>
</div><!-- // main_vis -->

<!-- movie_list -->
<div class="movie_list mt40">
	<ul>
		<c:forEach var="list" items="${list }" varStatus="stat">
			<c:url var="viewURL" value="/movie/movieView.mt">
				<c:param name="movie_no" value="${list.movie_no }" />
				<c:param name="currentPage" value="${currentPage }" />
			</c:url>
			<li>
				<a href="${viewURL }" class="list"> 
				<img src="/project/upload/movie/${list.poster}" alt="영화포스터" /> 
				<span class="detail">상세보기</span>
					<div class="explan">
						<p>
							<strong>감독</strong> : ${list.director}
						</p>
						<p>
							<strong>개봉</strong> : <fmt:formatDate value="${list.show_date }" pattern="yyyy.MM.dd"></fmt:formatDate>
						</p>
					</div>
				</a>
				<span class="btn btnC_02 btnF_01">
					<input type="button" value="예매하기" onclick="javascript:location.href='<%=cp%>/reserve/reserveMain.mt'"/>
				</span>
			</li>
		</c:forEach>
	</ul>
	<a href="<%=cp %>/movie/movieList.mt" class="more">더보기</a>
</div><!-- // movie_list -->

<!-- 공지사항 -->
<div class="notice_grp">
	<strong>공지사항</strong>
	<div id="notice5" class="notice">
		<div class="open-event fl">
			<ul class="notice-list">
				<c:forEach var="list2" items="${list2 }" varStatus="stat">
					<c:url var="viewURL" value="/notice/noticeView.mt">
						<c:param name="no" value="${list2.no}"/>
						<c:param name="currentPage" value="${currentPage }"/>
					</c:url>
					<li>
						<a href="${viewURL}" class="list">${list2.subject }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="control">
			<a href="#none" class="play" title="재생">▷</a>
			<a href="#none" class="stop" title="정지">■</a>
		</div>
		<script type="text/javascript">fn_article3('notice5','bt5',true);</script>
	</div>
	<a href="<%=cp %>/notice/noticeList.mt" class="more">더보기</a>
</div><!-- // 공지사항 -->

<!-- magazine_banner -->
<div class="magazine_banner">
	<a href="<%=cp %>/magazine/magazineList.mt"><img src="<%= cp %>/images/sample_magazine_01.jpg" alt="대표 매거진 이미지" /></a>
</div><!-- // magazine_banner -->
