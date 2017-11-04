<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String cp = request.getContextPath(); %>

<div class="movie_list">
			<h3 class="sub_tit">상영작</h3>
			<ul>
				<c:forEach var="list" items="${list }" varStatus="stat">
				<c:url var="viewURL" value="/movie/movieView.mt">
					<c:param name="movie_no" value="${list.movie_no }" />
					<c:param name="currentPage" value="${currentPage }" />
				</c:url>
				<li><a href="${viewURL }" class="list"> 
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
				</a> <span class="btn btnC_02 btnF_01"> <input type="button"
						value="예매하기" onclick="javascript:location.href='<%=cp%>/reserve/reserveMain.mt'"/>
				</span></li>
			</c:forEach>
			</ul>
		</div><!-- // movie_list -->

		<c:if test="${session_member_grade == 1}">
			<div class="btn_type_05">
				<a href="<%=cp%>/admin/movieWrite.mt" class="btn btnC_03 btnP_04">
						<span>글쓰기</span>
				</a>
			</div>
		</c:if>

		<!-- paging -->
		<div class="paging">
			${pagingHtml}
		</div>
		<!-- // paging -->