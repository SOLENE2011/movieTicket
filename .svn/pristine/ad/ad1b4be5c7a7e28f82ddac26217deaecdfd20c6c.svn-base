<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String cp = request.getContextPath();
%>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<div class="event_list">
			<h3 class="sub_tit">이벤트</h3>
			<c:if test="${fn:length(eventList) le 0}">
				<strong class="tac">등록된 이벤트가 없습니다.</strong>
			</c:if>
			<ul>
				<c:forEach var="list" items="${eventList}">
					<c:url var="viewURL" value="adminEventView.mt">
						<c:param name="event_no" value="${list.event_no }"/>
						<c:param name="currentPage" value="${currentPage }"/>
					</c:url>
				<li>
					<a href="${viewURL}" class="list">
						<p class="pic"><img src="/project/upload/event/${list.image1 }" alt="이벤트" /></p>
						<div class="explan">
							<p class="tit"><strong>제목</strong> : ${list.subject }</p>
							<p><strong>기간</strong> : <fmt:formatDate value="${list.e_start_date }" pattern="yyyy.MM.dd"/> ~  <fmt:formatDate value="${list.e_end_date}" pattern="yyyy.MM.dd"/>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div><!-- // event_list -->
		<div class="btn_type_03">
			<a href="adminEventWrite.mt" class="btn btnC_03 btnP_04">
				<span>글쓰기</span>
			</a>
		</div>
		
		<!-- search -->
		<div class="search_form">
			<form>
				<div class="inner">
					<select class="slct w100" name="searchNum">
						<option value="0">제목</option>
						<option value="1">내용</option>
					</select>
					<input class="txt w100" type="text" name="isSearch" />
					<span class="btn btnC_04 btnP_04">
						<input type="submit" value="검색" />
					</span>
				</div>
			</form>	
		</div>
		<!-- paging -->
		<div class="paging">
			${pagingHtml }
		</div>
	</div>
</div>