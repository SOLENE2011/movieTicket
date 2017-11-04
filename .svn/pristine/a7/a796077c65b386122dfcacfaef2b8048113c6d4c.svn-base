<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>

<script type="text/javascript">
	function img_view(imgname) {
		window.open("/project/admin/imgView.mt?img=" + imgname, "크게보기");
	}
</script>

<div class="movie_grp">
	<div class="movie_pic">
		<a onclick="img_view('${movie.poster}')"> <img
			src="/project/upload/movie/${movie.poster}" alt="영화포스터" />
		</a>
	</div>
	<div class="movie_txt">
		<p class="tit">${movie.movie_name}</p>
		<dl>
			<dt>개요</dt>
			<dd>${movie.summary}</dd>
			<dt>감독</dt>
			<dd>${movie.director}</dd>
			<dt>출현</dt>
			<dd>${movie.actor}</dd>
			<dt>개봉</dt>
			<dd>
				<fmt:formatDate value="${movie.show_date }" pattern="yyyy.MM.dd"></fmt:formatDate>
			</dd>
			<dt>평점</dt>
			<dd>${movie.movie_score}</dd>
		</dl>
		<div class="movie_btn">
			<span class="btn btnC_02 btnF_01 mr10"> <input type="button"
				value="예매하기" onclick="javascript:location.href='<%=cp%>/reserve/reserveMain.mt'"/>
			</span> 
			<a href="<%=cp%>/mypage/delWishList.mt?movie_no=${movie.movie_no}" class="btn btnC_02 btnF_01"> <span>위시리스트에서 삭제</span>
			</a>
		</div>
	</div>
</div>
<h3 class="sub_tit">줄거리</h3>
<p class="summary">${movie.story}</p>

<h3 class="sub_tit">스틸컷</h3>
<div class="movie_steel">
	<div class="inner">
		<ul>
			<li>
				<c:if test="${movie.cut1 != '사진없음'}">
				<a onclick="img_view('${movie.cut1}')">
					<img src="/project/upload/movie/${movie.cut1}" alt="" />
				</a>
				</c:if>
				<c:if test="${movie.cut1 == '사진없음'}">
					<img src="/project/upload/movie/noimage.gif" alt="" />
				</c:if>
			</li>
			<li>
				<c:if test="${movie.cut2 != '사진없음'}">
				<a onclick="img_view('${movie.cut2}')">
					<img src="/project/upload/movie/${movie.cut2}" alt="" />
				</a>
				</c:if>
				<c:if test="${movie.cut2 == '사진없음'}">
					<img src="/project/upload/movie/noimage.gif" alt="" />
				</c:if>
			</li>
			<li>
				<c:if test="${movie.cut3 != '사진없음'}">
				<a onclick="img_view('${movie.cut3}')">
					<img src="/project/upload/movie/${movie.cut3}" alt="" />
				</a>
				</c:if>
				<c:if test="${movie.cut3 == '사진없음'}">
					<img src="/project/upload/movie/noimage.gif" alt="" />
				</c:if>
			</li>
			<li><c:if test="${movie.cut1 != '사진없음'}">
				<a onclick="img_view('${movie.cut1}')">
					<img src="/project/upload/movie/${movie.cut1}" alt="" />
				</a>
				</c:if>
				<c:if test="${movie.cut1 == '사진없음'}">
					<img src="/project/upload/movie/noimage.gif" alt="" />
				</c:if>
			</li>
			<li>
				<c:if test="${movie.cut2 != '사진없음'}">
				<a onclick="img_view('${movie.cut2}')">
					<img src="/project/upload/movie/${movie.cut2}" alt="" />
				</a>
				</c:if>
					<c:if test="${movie.cut2 == '사진없음'}">
					<img src="/project/upload/movie/noimage.gif" alt="" />
				</c:if>
			</li>
		</ul>
	</div>
</div>

<div class="btn_type_04">
	<a href="javascript:history.back()" class="btn btnC_03 btnF_02 mr10">
		<span>목록</span>
	</a>
</div>
