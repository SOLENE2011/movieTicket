<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>
<script type="text/javascript">
	function openZipcode(joinform){
		var url="<%=cp%>/member/zipCheckAction.mt";
		cw = screen.availWidth; //화면 넓이
		ch = screen.availHeight; //화면 높이

		sw = 410; //띄울 창의 넓이
		sh = 400; //띄울 창의 높이

		ml = (cw - sw) / 2; //가운데 띄우기위한 창의 x위치
		mt = (ch - sh) / 2; //가운데 띄우기위한 창의 y위치
		window
				.open(
						url,
						"confirm",
						"width="
								+ sw
								+ ", height="
								+ sh
								+ ",top="
								+ mt
								+ ", left="
								+ ml
								+ ", toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no");
	}

	function check() {
		var f = document.memberModifyForm;

		if (f.passwd.value == "") {
			alert("비밀번호를 입력하세요");
			f.passwd.focus();
			return false;
		} else if ((f.name.value == "") || (f.name.value.length <= 1)) {
			alert("이름을 제대로 입력해 주세요");
			f.name.focus();
			return false;
		} else if (f.id.value == "") {
			alert("아이디를 입력하세요");
			f.id.focus();
			return false;
		} else if (f.passwd.value != f.passwd2.value) {
			alert("비밀번호가 일치하지 않습니다");
			f.passwd.value = "";
			f.passwd2.value = "";
			f.passwd.focus();
			return false;
		} else if (f.email.value == "") {
			alert("이메일을 제대로 입력해주세요");
			f.email.focus();
			return false;
		} else if (f.phone.value == "") {
			alert("휴대폰 번호를 입력하세요");
			f.phone.focus();
			return false;
		}
		return true;
	}
</script>

<div class="mypage_grp">
	<div class="mypage_list">
		<ul>
			<li><a href="<%=cp%>/mypage/memberModify.mt">회원정보수정</a></li>
			<li><a href="<%=cp%>/mypage/reserveList.mt">예매내역</a></li>
			<li class="on"><a href="<%=cp%>/mypage/cancelList.mt">취소내역</a></li>
			<li><a href="<%=cp%>/mypage/wishList.mt">위시리스트</a></li>
			<li><a href="<%=cp %>/mypage/mcoinPage.mt">M_COIN</a></li>
		</ul>
	</div>
	<div class="mypage_ct">


		<h3 class="sub_tit">취소내역</h3>
		<div class="tbl_type_02">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
				<colgroup>
					<col style="width:15%" />
					<col style="width:25%" />
					<col style="width:10%" />
					<col style="width:15%" />
					<col style="width:15%" />
					<col style="width:15%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">예매번호</th>
						<th scope="col">영화명</th>
						<th scope="col">영화관</th>
						<th scope="col">상영일시</th>
						<th scope="col">예매일</th>
						<th scope="col">취소신청일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mypage" items="${list}" varStatus="stat">
						<tr>
							<td>${mypage.reserve_master_no}</td>
							<td>${mypage.movie_name}</td>
							<td>${mypage.room_name}</td>
							<td>${mypage.show_date}</td>
							<td><fmt:formatDate value="${mypage.reg_date}"
									pattern="yy/MM/dd" /></td>
							<td><fmt:formatDate value="${mypage.cancel_date}"
									pattern="yy/MM/dd" /></td>
						</tr>
					</c:forEach>
					<c:if test="${totalCount<1}">
						<tr>
							<td colspan="6">취소내역이 없습니다.</td>
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