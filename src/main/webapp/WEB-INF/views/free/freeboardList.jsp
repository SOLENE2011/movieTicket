<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String cp = request.getContextPath(); %>
<div class="terms_grp">
	<div class="terms_ct">
		<h3 class="sub_tit">자유게시판</h3>
		<div class="tbl_type_02">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 자유게시판</caption>
				<colgroup>
					<col style="width:7%;" />
					<col style="width:25%;" />
					<col style="width:8%;" />
					<col style="width:8%;" />
					<col style="width:7%;" />
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
					<c:forEach var="list" items="${freeBoardList}">
						<c:url var="viewURL" value="freeBoardView.mt">
							<c:param name="free_no" value="${list.free_no}" />
							<c:param name="currentPage" value="${currentPage}" />
						</c:url>
					<tr>
						<td>${list.free_no}</td>
						<td class="subject">
							<a href="${viewURL}">${list.subject}</a>
						</td>
						<td>${list.name}</td> 
						<td><fmt:formatDate value="${list.reg_date}" pattern="yyyy.MM.dd" /></td>
						<td>${list.read_hit}</td>
					</tr>
					</c:forEach>
					<c:if test="${fn:length(freeBoardList) le 0}">
					<tr>
						<td colspan="5">등록된 글이 없습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="btn_type_03">
			<a href="freeBoardWrite.mt" class="btn btnC_03 btnP_04">
				<span>글쓰기</span>
			</a>
		</div>
		
		<!-- 검색 -->
		<div class="search_form">
			<form action="#none">
				<fieldset>
					<legend>자유게시판 검색폼</legend>
					<div class="inner">
						<select class="slct w100" name="searchNum">
							<option value="0">이름</option>
							<option value="1">제목</option>
						</select>
						<input type="text" class="txt w100" name="isSearch" maxlength="20">
						<span class="btn btnC_04 btnP_04">
							<input type="submit" value="검색" />
						</span>
					</div>
				</fieldset>
			</form>
		</div>
		
		<!-- 페이징 -->
		<div class="paging">
			${pagingHtml}
		</div>
		
	</div>
</div>