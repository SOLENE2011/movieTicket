<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String cp = request.getContextPath(); %>

<div class="mypage_grp">
	<div class="mypage_list">
		<ul>
	        <li><a href="<%=cp%>/mypage/memberModify.mt">회원정보수정</a></li>
			<li><a href="<%=cp%>/mypage/reserveList.mt">예매내역</a></li>
			<li><a href="<%=cp%>/mypage/cancelList.mt">취소내역</a></li>
			<li><a href="<%=cp%>/mypage/wishList.mt">위시리스트</a></li>
			<li class="on"><a href="<%=cp %>/mypage/mcoinPage.mt">M_COIN</a></li>
     	</ul>
	</div>
	<div class="mypage_ct">
		<h3 class="sub_tit">M 코인</h3>
		<form action="mcoinPageSuccess.mt" method="post" name="mcoinForm">
			<%-- <input type="hidden" name="mticket_coin" value="${member.mticket_coin }"/> --%>
			<div class="tbl_type_01">
				<table>
					<caption></caption>
					<colgroup>
						<col style="width:120px;" />
						<col />
						<col style="width:120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">보유한 성인표</th>
							<td>
								${member.adult_ticket}
							</td>
							<th scope="row">성인표</th>
							<td>
								<select class="slct w200" name="adult_ticket">
									<c:forEach begin="0" end="10" var="adult">
										<option value="${adult}">${adult}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">보유한 학생표</th>
							<td>	
								${member.child_ticket}
							</td>
							<th scope="row" >학생표</th>
							<td>
								<select class="slct w200" name="child_ticket">
									<c:forEach begin="0" end="10" var="child">
										<option value="${child}">${child}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">잔여 M코인</th>
							<td colspan="3">
								${member.mticket_coin}
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_04 btnP_04">
					<input type="submit" value="교환" />
				</span>
			</div>
		</form>
	</div>
</div>