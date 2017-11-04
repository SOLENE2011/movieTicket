<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String cp = request.getContextPath(); %>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	
	<div class="admin_ct">
		<div class="magazine_grp">
			<h3 class="sub_tit">스페셜 리포트</h3>
			<c:forEach var="list" items="${list }" varStatus="stat">
				<c:url var="viewURL" value="/admin/magazineView.mt">
					<c:param name="magazine_no" value="${list.magazine_no }"/>
					<c:param name="currentPage" value="${currentPage }"/>
				</c:url>
				<div class="magazine_list">
					<a href="${viewURL }" class="list">
						<p class="pic"><img src="<%=cp %>/upload/magazine/${list.image1 }" alt="메거진이미지" /></p> 
						<div class="contents">
							<input type="hidden" name="magazine_no" value="${magazine.magazine_no}"/>
							<input type="hidden" name="currentPage" value="${currentPage}"/>
							<input type="hidden" name="currentPage2" value="${currentPage2}"/>
							<p class="tit"><strong>${list.subject }</strong></p>
							<p class="txt">${list.subject2 }</p>
							<p class="txt">조회수:${list.readhit }</p> 
							<p class="date"><fmt:formatDate value="${list.reg_date }" pattern="yyyy.MM.dd"></fmt:formatDate></p> 
						</div>
					</a>
				</div>
			</c:forEach>
			<c:if test="${fn:length(list) le 0}">
				<p class="tac">등록된 매거진이 없습니다.</p>
			</c:if>	
			<c:if test="${session_member_grade == 1}">
			<div class="btn_type_03">
				<a href="adminMagazineWrite.mt" class="btn btnC_03 btnP_04">
					<span>글쓰기</span>
				</a>
			</div>
			</c:if>
			<!-- search -->
			<div class="search_form">
				<form>
					<div class="inner">
						<select class="slct w100" name="searchNum" id="searchNum">
							<option value="0">제목</option>
							<option value="1">내용</option>
						</select>
						<input class="txt w100" type="text" name="isSearch" id="isSearch"/>
						<span class="btn btnC_04 btnP_04">
							<input type="submit" value="검색" style="font-size:11px; padding-bottom:20; vertical-align:middle;" />
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
</div>
