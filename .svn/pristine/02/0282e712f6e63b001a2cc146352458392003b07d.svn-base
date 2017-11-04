<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
%>
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
		<h3 class="sub_tit">예매내역상세</h3>
		<div class="tbl_type_01">
			<table>
				<caption>아이디,비밀번호,비밀번호확인,이름,주민등록번호,주소,전화번호,이메일,수신확인 작성하는 표</caption>
				<colgroup>
					<col style="width:120px" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">예매번호</th>
						<td>
							${mypageModel2.reserve_master_no}
						</td>
					</tr>
					<tr>
						<th scope="row">영화명</th>
						<td>
							${mypageModel2.movie_name}
						</td>
					</tr>
					<tr>
						<th scope="row">영화관</th>
						<td>
							${mypageModel2.room_name}
						</td>
					</tr>
					<tr>
						<th scope="row">상영일시</th>
						<td>
							${mypageModel2.show_date}
						</td>
					</tr>
					<tr>
						<th scope="row">상영시간</th>
						<td>
							${mypageModel2.start_time}
						</td>
					</tr>
					<tr>
						<th scope="row">인원 &#47; 금액</th>
						<td>
							<span class="ibk">대인 : 2명 ,금액 :<strong class="ibk ml5 pt_red">10000 원 </strong></span>
							<span class="ibk">소인 : 2명 ,금액 :<strong class="ibk ml5 pt_red">7000 원</strong></span>
							<span class="ibk">총 :<strong class="ibk ml5 pt_red">17000 원</strong></span>
						</td>
					</tr>
					<tr>
						<th scope="row">좌석</th>
						<td>A1, A2</td>
					</tr>
					<tr>
						<th scope="row">상태</th>
						<td>
							예매완료
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="btn_type_04">
			<a href="javascript:history.back()" class="btn btnC_03 btnF_02 mr10">
				<span>뒤로가기</span>
			</a>
			<span class="btn btnC_04 btnF_02">
				<a href="cancelReserve.mt?reserve_no=${mypageModel2.reserve_master_no}" class="btn btnC_04 btnP_03">
					<input type="button" value="예매취소" />
				</a>
			</span>
		</div>
	</div>
</div>