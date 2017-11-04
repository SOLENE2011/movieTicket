<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<c:forEach var="list" items="${list}" varStatus="stat">
	<div class="movie_grp">
		<div class="movie_pic">
			<a href="#none" onclick="img_view('${list.poster}')">
				<span class="detail">크게보기</span>
				<img src="/project/upload/movie/${list.poster}" alt="영화포스터" />
				
			</a>
		</div>
		<div class="movie_txt">
			<p class="tit">${list.movie_name}</p>
			<dl>
				<dt>개요</dt>
				<dd>${list.summary}</dd>
				<dt>감독</dt>
				<dd>${list.director}</dd>
				<dt>출현</dt>
				<dd>${list.actor}</dd>
				<dt>개봉</dt>
				<dd>
					<fmt:formatDate value="${list.show_date}" pattern="yyyy.MM.dd"></fmt:formatDate>
				</dd>
				<dt>평점</dt>
				<dd>
					<form action="movieGrade.mt" method="post" name="movie_score">
						<input type="hidden" name="movie_no" value="${list.movie_no}" />
						<input type="hidden" name="currentPage" value="${currentPage}" />
						<strong class="iblock pt_red mr10 fz18">${list.movie_score}</strong>
						<select class="slct w100" name="movie_score">
							<c:forEach var="score" begin="1" end="10">
							<option value="${score}">평점 ${score}점</option>
							</c:forEach>
						</select>
						<span class="btn btnC_04 btnP_04 ml10">
							<input type="submit" value="평점주기" />
						</span>
					</form>
				</dd>
			</dl>
			<div class="movie_btn">
				<span class="btn btnC_02 btnF_01 mr10">
					<input type="button" value="예매하기" onclick="javascript:location.href='<%=cp%>/reserve/reserveMain.mt'"/>
				</span>
				<a href="<%=cp %>/mypage/wishList_Check.mt?movie_no=${list.movie_no}&currentPage=${currentPage}" class="btn btnC_02 btnF_01">
					<span>위시리스트</span>
				</a> 
				<c:if test="${session_member_grade == 1}">
				<a href="<%=cp%>/admin/movieUpdate.mt?movie_no=${list.movie_no}" class="btn btnC_01 btnF_04">
					<span>수정</span>
				</a> 
				<a href="javascript:del_check('movieDelete.mt?movie_no=${list.movie_no}');" class="btn btnC_01 btnF_04">
					<span>삭제</span>
				</a>
				</c:if>
				
			</div>
		</div>
	</div>
	<h3 class="sub_tit">줄거리</h3>
	<p class="summary">${list.story}</p>

	<h3 class="sub_tit">스틸컷</h3>
	<div class="movie_steel">
		<div class="inner">
			<ul>
				<li>
					<c:if test="${list.cut1 != '사진없음'}">
					<a onclick="img_view('${list.cut1}')">
						<img src="/project/upload/movie/${list.cut1}" alt="" />
					</a>
					</c:if>
					<c:if test="${list.cut1 == '사진없음'}">
						<img src="/project/upload/movie/noimage.gif" alt="" />
					</c:if>
				</li>
				<li>
					<c:if test="${list.cut2 != '사진없음'}">
					<a onclick="img_view('${list.cut2}')">
						<img src="/project/upload/movie/${list.cut2}" alt="" />
					</a>
					</c:if>
					<c:if test="${list.cut2 == '사진없음'}">
						<img src="/project/upload/movie/noimage.gif" alt="" />
					</c:if>
				</li>
				<li>
					<c:if test="${list.cut3 != '사진없음'}">
					<a onclick="img_view('${list.cut3}')">
						<img src="/project/upload/movie/${list.cut3}" alt="" />
					</a>
					</c:if>
					<c:if test="${list.cut3 == '사진없음'}">
						<img src="/project/upload/movie/noimage.gif" alt="" />
					</c:if>
				</li>
				<li>
					<c:if test="${list.cut1 != '사진없음'}">
					<a onclick="img_view('${list.cut1}')">
						<img src="/project/upload/movie/${list.cut1}" alt="" />
					</a>
					</c:if>
					<c:if test="${list.cut1 == '사진없음'}">
						<img src="/project/upload/movie/noimage.gif" alt="" />
					</c:if>
				</li>
				<li>
					<c:if test="${list.cut2 != '사진없음'}">
					<a onclick="img_view('${list.cut2}')">
						<img src="/project/upload/movie/${list.cut2}" alt="" />
					</a>
					</c:if>
					<c:if test="${list.cut2 == '사진없음'}">
						<img src="/project/upload/movie/noimage.gif" alt="" />
					</c:if>
				</li>
			</ul>
		</div>
	</div>
</c:forEach>

<div class="btn_type_04">
	<a href="javascript:history.back()" class="btn btnC_03 btnF_02 mr10">
		<span>목록</span>
	</a>
</div>