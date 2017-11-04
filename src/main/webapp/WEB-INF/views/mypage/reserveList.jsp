<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>
<script type="text/javascript">
	function check() {
		var check = confirm("확인을 클릭하시면 예매가 취소됩니다.");
		if (check) {
			return true;
		} else {
			return false;
		}
	}
	
</script>

<div class="mypage_grp">
	<div class="mypage_list">
		<ul>
			<li><a href="<%=cp%>/mypage/memberModify.mt">회원정보수정</a></li>
			<li class="on"><a href="<%=cp%>/mypage/reserveList.mt">예매내역</a></li>
			<li><a href="<%=cp%>/mypage/cancelList.mt">취소내역</a></li>
			<li><a href="<%=cp%>/mypage/wishList.mt">위시리스트</a></li>
			<li><a href="<%=cp %>/mypage/mcoinPage.mt">M_COIN</a></li>
		</ul>
	</div>
	<div class="mypage_ct">
		<h3 class="sub_tit">예매내역</h3>
		<div class="tbl_type_02">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
				<colgroup>
					<col style="width:15%" />
					<col style="width:25%" />
					<col style="width:10%" />
					<col style="width:15%" />
					<col style="width:10%" />
					<col style="width:10%" />
					<col style="width:8%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">예매번호</th>
						<th scope="col">영화명</th>
						<th scope="col">영화관</th>
						<th scope="col">상영일시</th>
						<th scope="col">예매일</th>
						<th scope="col">상태</th>
						<th scope="col">취소</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mypage" items="${list}" varStatus="stat">
						<tr>
							<td>${mypage.reserve_master_no}</td>
							<td class="subject tac"><a href="<%=cp%>/mypage/reserveView.mt?reserve_master_no=${mypage.reserve_master_no}">${mypage.movie_name}</a></td>
							<td>${mypage.room_name}</td>
							<td>${mypage.show_date}</td>
							<td><fmt:formatDate value="${mypage.reg_date}" pattern="yyyy/MM/dd" /></td>
							<td><c:if test="${mypage.cancel != Y}">예매완료</c:if></td>
							<td>
								<a href="cancelReserve.mt?reserve_no=${mypage.reserve_master_no}" class="btn btnC_04 btnP_03">
									<span onclick="return check()">취소</span>
								</a>
								
							</td>
							
						</tr>
					</c:forEach>
					<c:if test="${totalCount < 1}">
						<tr>
							<td colspan="10">예매 내역이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			
		</div>
		<div class="paging">
			<span class="paging">${pagingHtml}</span>
		</div>
		
		
	</div>
</div>