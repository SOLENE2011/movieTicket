<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String cp = request.getContextPath(); %>
<div class="terms_grp">
	<div class="terms_list">
		<ul>
			<li class="on"><a href="<%= cp %>/notice/noticeList.mt">공지사항</a></li>
			<li><a href="<%= cp %>/qna/qnaList.mt">Q&amp;A</a></li>
			<li><a href="<%= cp %>/common/accessterms.mt">이용약관</a></li>
			<li><a href="<%= cp %>/common/privacy.mt">개인정보취급방침</a></li>
		</ul>
	</div>

	<div class="terms_ct">
		<h3 class="sub_tit">공지사항</h3>
		<div class="tbl_type_02">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
				<colgroup>
					<col style="width: 7%;" />
					<col style="width: 25%;" />
					<col style="width: 8%;" />
					<col style="width: 8%;" />
					<col style="width: 7%;" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">날짜</th>
						<th scope="col">조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${noticeList}" varStatus="stat">
						<c:url var="viewURL" value="noticeView.mt">
							<c:param name="no" value="${list.no}" />
							<c:param name="currentPage" value="${currentPage }" />
						</c:url>

						<tr>
							<td>${list.no}</td>
							<td class="subject"><a href="${viewURL}">${list.subject}</a></td>
							<td>${list.name}</td>
							<td><fmt:formatDate value="${list.regdate}" pattern="yyyy.MM.dd" /></td>
							<td>${list.readhit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${fn:length(noticeList) le 0}">
				<br />
				<center>등록된 게시물이 없습니다</center>
				<br />
			</c:if>
		</div>
		<div class="btn_type_03">
		<c:if test="${session_member_grade == 1 }">
			<a href="<%=cp %>/admin/adminNoticeWrite.mt"
				class="btn btnC_03 btnP_04"> <span>글쓰기</span>
			</a>
			</c:if>
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
						<input type="submit" value="검색" >
					</span>
				</div>
			</form>
		</div>
		
		<div class="paging">${pagingHtml}</div>
	</div>
</div>