<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String cp = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/jquery-ui.css" />
<script type="text/javascript" src="<%= cp %>/js/jquery-ui.js"></script>
<script type="text/javascript">
	$(function(){
		$('#show_date').datepicker();
		$('#start_date').datepicker();
		$('#end_date').datepicker();
	})
	
	$(function(){
		var schedule_btn = $(".schedule_delete");
		
		schedule_btn.each(function(){
			var btn = $(this).children('.btn');
			
			btn.on('click',function(){
				var check = confirm("삭제하시겠습니까?");	
				if(check){
					return true;
				}else{
					return false;
				}
			})
		})
	})
</script>


<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li class="on"><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<h3 class="sub_tit">시간표 등록</h3>
		<form action="timeTableWrite.mt" method="post" name="schedule">
			<div class="tbl_type_02">
				<table>
					<caption>시간표 등록</caption>
					<colgroup>
						<col style="width:20%" />
						<col style="width:20%" />
						<col style="width:12%" />
						<col style="width:12%" />
						<col style="width:12%" />
						<col style="width:12%" />
						<col style="width:12%" />
						<col style="width:12%" />
						<col style="width:12%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">영화목록</th>
							<th scope="col">상영관</th>
							<th scope="col">개봉일</th>
							<th scope="col">종료일</th>
							<th scope="col">상영일</th>
							<th scope="col">시작시간</th>
							<th scope="col">종료시간</th>
							<th scope="col">대인금액</th>
							<th scope="col">소인금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<select class="slct" id="movieSelection" name="movie_no">
									<c:forEach var="movie" items="${timeMovie}">
									<option value="${movie.movie_no}">${movie.movie_name}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<select class="slct" id="roomSelection" name="room_no">
									<c:forEach var="room" items="${timeRoom}">
									<option value="${room.room_no}">${room.room_name} 총 좌석수 : 20</option>
									</c:forEach>
								</select>
							</td>
							<td><input type="text" class="txt" name="start_date" id="start_date"/></td>
							<td><input type="text" class="txt" name="end_date" id="end_date"/></td>
							<td><input type="text" class="txt" name="show_date" id="show_date"/></td>
							<td>
								<select name="start_time" class="slct">
									<c:forEach begin="1" end="23" var="hour">
										<option value="${hour}:00">${hour}:00</option>
										<option value="${hour}:30">${hour}:30</option>
									</c:forEach>
										<option value="24:00">24:00</option>
								</select>
							</td>
							<td>
								<select name="end_time" class="slct">
									<c:forEach begin="1" end="23" var="hour">
										<option value="${hour}:00">${hour}:00</option>
										<option value="${hour}:30">${hour}:30</option>
									</c:forEach>
										<option value="24:00">24:00</option>
								</select>
							</td>
							<td>
								<select name="adult_amt" class="slct">
									<option value="10000">10000원</option>
									<option value="12000">12000원</option>
								</select>
							</td>
							<td>
								<select name="child_amt" class="slct">
									<option value="7000">7000원</option>
									<option value="9000">9000원</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_04 btnP_04">
					<input type="submit" value="저장" />
				</span>
			</div>
		</form>

		<h3 class="sub_tit">시간표 목록</h3>
		<div class="tbl_type_02">
			<table>
				<caption>시간표 목록</caption>
				<colgroup>
					<col style="width:5%" />
					<col style="width:8%" />
					<col style="width:16%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:7%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
					<col style="width:8%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">영화번호</th>
						<th scope="col">영화명</th>
						<th scope="col">개봉일</th>
						<th scope="col">종료일</th>
						<th scope="col">상영일</th>
						<th scope="col">상영관</th>
						<th scope="col">좌석수</th>
						<th scope="col">시작시간</th>
						<th scope="col">종료시간</th>
						<th scope="col">대인금액</th>
						<th scope="col">소인금액</th>
						<th scope="col">삭제유무</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="time" items="${timeList}">
					<tr>
						<td>${time.time_no}</td>
						<td>${time.movie_no}</td>
						<td>${time.movie_name}</td>
						<td><fmt:formatDate value="${time.start_date}" pattern="yyyyMMdd" /></td>
						<td><fmt:formatDate value="${time.end_date}" pattern="yyyyMMdd" /></td>
						<td>${time.show_date}</td>
						<td>${time.room_name}</td>
						<td>${time.reserved_seat} &#47; ${time.total_seat}</td>
						<td>${time.start_time}</td>
						<td>${time.end_time}</td>
						<td>${time.adult_amt}</td>
						<td>${time.child_amt}</td>
						<td class="schedule_delete">
							<a href="timeTableDelete.mt?time_no=${time.time_no}&time_detail_no=${time.time_detail_no}" class="btn btnC_04 btnP_03">
								<span>삭제</span>
							</a>
						</td>
					</tr>
					</c:forEach>
					<c:if test="${fn:length(timeList) le 0}">
					<tr>
						<td colspan="13" class="tac">등록된 스케쥴이 없습니다.</td>
					</tr>
					</c:if>
				</tbody>
			</table>
		</div>
		
		<!-- paging -->
		<div class="paging">
			${pagingHtml}
		</div>
	</div>
</div>