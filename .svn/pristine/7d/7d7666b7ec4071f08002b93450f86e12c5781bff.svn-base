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
			<li><a href="<%=cp%>/mypage/cancelList.mt">취소내역</a></li>
			<li class="on"><a href="<%=cp%>/mypage/wishList.mt">위시리스트</a></li>
			<li><a href="<%=cp%>/mypage/mcoinPage.mt">M_COIN</a></li>
		</ul>
	</div>
	<div class="mypage_ct">


		<h3 class="sub_tit">보고싶은 영화</h3>
		<div class="movie_list">
			<ul>


				<c:forEach var="list" items="${list}" varStatus="stat">
					<c:url var="viewURL" value="wishView.mt">
						<c:param name="movie_no" value="${list.movie_no}" />
						<c:param name="currentPage" value="${currentPage }" />
					</c:url>
					<!-- 영화 리스트 꺼내오기 -->
					<li><a href="${viewURL }" class="list"> <img
							src="/project/upload/movie/${list.poster}" /> <span
							class="detail">상세보기</span>
							<div class="explan">
								<p>
									<strong>영화</strong> : ${list.movie_name}
								</p>
								<p>
									<strong>개봉</strong> :
									<fmt:formatDate value="${list.show_date}"
										pattern="yyyy.MM.dd"></fmt:formatDate>
								</p>
							</div>
					</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:if test="${totalCount<1}">
			<tr>
				<td colspan="10">위시리스트에 추가된 영화가 없습니다.^^</td>
			</tr>
		</c:if>

		<div class="paging">

			<span class="paging">${pagingHtml}</span>

		</div>

	</div>
</div>