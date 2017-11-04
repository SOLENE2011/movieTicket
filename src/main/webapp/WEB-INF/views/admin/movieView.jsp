<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>

<script type="text/javascript">
	function del_check(url) {
		if (confirm("삭제 하겠습니까?")) {
			location.href(url);
		}
	}
	
	function img_view(imgname) {
		window.open("imgView.mt?img="+imgname, "크게보기");
	}
</script>

<div class="admin_grp">

	<div class="admin_list">
		<ul>
			<li class="on"><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>

	<div class="admin_ct">
		<c:forEach var="list" items="${list}" varStatus="stat">
		<div class="movie_grp">
			<div class="movie_pic">
				<a href="#none" onclick="img_view('${list.poster}')">
					<span class="detail">크게보기</span>
					<img src="/project/upload/movie/${list.poster}" alt="영화포스터"/>
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
						<fmt:formatDate value="${list.show_date }" pattern="yyyy.MM.dd"></fmt:formatDate>
					</dd>
					<dt>평점</dt>
					<dd><strong class="iblock pt_red mr10 fz18">${list.movie_score}</strong></dd>
				</dl>
				<div class="movie_btn">
					<span class="btn btnC_02 btnF_01 mr10"> <input
						type="button" value="예매하기" onclick="javascript:location.href='<%=cp%>/reserve/reserveMain.mt'"/>
					</span> <a href="wish_list.html" class="btn btnC_02 btnF_01"> <span>위시리스트</span>
					</a> <a href="<%=cp%>/admin/movieUpdate.mt?movie_no=${list.movie_no}"
						class="btn btnC_01 btnF_04"> <span>수정</span>
					</a> <a
						href="javascript:del_check('movieDelete.mt?movie_no=${list.movie_no}');"
						class="btn btnC_01 btnF_04"> <span>삭제</span>
					</a>
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
	</div>
</div>