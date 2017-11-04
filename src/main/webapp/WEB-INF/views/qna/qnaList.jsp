<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--  -->
<% String cp = request.getContextPath(); %>
<div class="terms_grp">
	<div class="terms_list">
		<ul>
			<li><a href="<%= cp %>/notice/noticeList.mt">공지사항</a></li>
			<li class="on"><a href="<%= cp %>/qna/qnaList.mt">Q&amp;A</a></li>
			<li><a href="<%= cp %>/common/accessterms.mt">이용약관</a></li>
			<li><a href="<%= cp %>/common/privacy.mt">개인정보취급방침</a></li>
		</ul>
	</div>
	<div class="terms_ct">
		<h3 class="sub_tit">Q&amp;A</h3>
		<div class="tbl_type_02">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 Q&amp;A 표</caption>
				<colgroup>
					<col style="width: 8%" />
					<col />
					<col style="width: 10%" />
					<col style="width: 10%" />
					<col style="width: 8%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">날짜</th>
						<th scope="col">조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${qnaList}">
						<c:url var="viewURL" value="qnaView.mt">
							<c:param name="qna_no" value="${list.qna_no }" />
							<c:param name="currentPage" value="${currentPage }" />
						</c:url>
						<tr>
							<td>${list.qna_no }</td>
							<td style="text-align: left;"><c:if
									test="${list.re_step==1}">&nbsp;<img
										src="/project/images/icon/reply.gif">
								</c:if> <a href="${viewURL }">${list.subject }</a></td>
							<td>${list.name }</td>
							<td><fmt:formatDate value="${list.reg_date }"
									pattern="yyyy.MM.dd" /></td>
							<td>${list.readhit }</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="btn_type_03">
			<a href="<%=cp %>/qna/qnaWrite.mt" class="btn btnC_03 btnP_04"> <span>글쓰기</span>
			</a>
		</div>

		<!-- search -->
		<div class="search_form">
			<form action="#">
				<select class="slct w100" name="searchNum" id="searchNum">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">글쓴이</option>
				</select> <input class="txt w100" type="text" name="isSearch" /> <span
					class="btn btnC_04 btnP_04 mr10"> <input type="submit"
					value="검색" />
				</span>
			</form>
		</div>

		<div class="paging">${pagingHtml}</div>
	</div>
</div>
