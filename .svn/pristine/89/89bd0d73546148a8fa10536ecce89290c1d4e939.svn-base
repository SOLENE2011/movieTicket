<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String cp = request.getContextPath(); %>

<div class="event_list">
	<h3 class="sub_tit">이벤트</h3>
	<c:if test="${fn:length(eventList) le 0}">
		<strong class="tac">등록된 이벤트가 없습니다.</strong>
	</c:if>
	<ul>
		<c:forEach var="list" items="${eventList}">
			<c:url var="viewURL" value="eventView.mt">
				<c:param name="event_no" value="${list.event_no }"/>
				<c:param name="currentPage" value="${currentPage }"/>
			</c:url>
		<li>
			<c:if test="${session_member_grade == 0 || session_member_grade == null}">
			<a href="#none" class="list" onclick='eventDate(<fmt:formatDate value="${list.e_end_date}" pattern="yyyyMMdd"/>, ${list.event_no })'>
				<p class="pic"><img src="/project/upload/event/${list.image1 }" alt="이벤트" /></p>
				<div class="explan">
					<p class="tit"><strong>제목</strong> : ${list.subject }</p>
					<p><strong>기간</strong> : <fmt:formatDate value="${list.e_start_date }" pattern="yyyy.MM.dd"/> ~  <fmt:formatDate value="${list.e_end_date}" pattern="yyyy.MM.dd"/>
				</div>
			</a>
			</c:if>
			<c:if test="${session_member_grade == 1}">
			<a href="${viewURL}" class="list">
				<p class="pic"><img src="/project/upload/event/${list.image1 }" alt="이벤트" /></p>
				<div class="explan">
					<p class="tit"><strong>제목</strong> : ${list.subject }</p>
					<p><strong>기간</strong> : <fmt:formatDate value="${list.e_start_date }" pattern="yyyy.MM.dd"/> ~  <fmt:formatDate value="${list.e_end_date}" pattern="yyyy.MM.dd"/>
				</div>
			</a>
			</c:if>
		</li>
		</c:forEach>
		
	</ul>
</div><!-- // event_list -->

<c:if test="${session_member_grade == 1}">
<div class="btn_type_03">
	<a href="<%=cp %>/admin/adminEventWrite.mt" class="btn btnC_03 btnP_04">
		<span>글쓰기</span>
	</a>
</div>
</c:if>

<!-- search -->
<div class="search_form">
	<form>
	<!-- <form action=""> -->
		<div class="inner">
			<select class="slct w100" name="searchNum" id="searchNum">
				<option value="0">제목</option>
				<option value="1">내용</option>
			</select>
			<input class="txt w100" type="text" name="isSearch" id="isSearch"/>
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

<script type="text/javascript">
	 function eventDate(endDate, number){
		 
		var today = new Date(); 
		var year = today.getFullYear();
		var month = today.getMonth() + 1; 
		var day = today.getDate();
		
		
		if (("" + month).length == 1) month = "0" + month;
		if (("" + day).length  == 1) day  = "0" + day;
		var toDate	= year+''+month+''+day;
		
		if(toDate <= endDate){ 
		 location.href='<%=cp %>/event/eventView.mt?event_no='+number+'&currentPage=${currentPage}';
		}else{ 
		  alert('이벤트 기간이 아닙니다.');
		}
	}
	
</script>
