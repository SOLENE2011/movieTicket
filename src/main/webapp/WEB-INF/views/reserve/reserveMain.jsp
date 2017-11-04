<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder"%>
<% String cp = request.getContextPath(); %>

<script type="text/javascript" src="<%= cp %>/js/ajax.js"></script>
<script type="text/javascript" src="<%= cp %>/js/reserve.js"></script>
<script type="text/javascript" src="<%= cp %>/js/buildCalendar.js"></script>

<script type="text/javascript">
	//Page Load 시에 현재 날짜를 기준으로 달력 생성한다.
	window.onload = function() {	
		//initialize Calendar & visibilities
		buildCalendarM(thisToday.getFullYear(), thisToday.getMonth()+1, thisToday.getDate(), rsvPlayDateAllList, selDate);
		setTotalResultDiv("init", "");
	}
</script>

<div class="reserve_grp">
	<h3 class="sub_tit">예매</h3>
	<div class="reserve_inner i2" id="movieNcal">
		<div id="rmovie" class="inner">
			<p class="tit">영화선택</p>
			<div class="content" id="movieList">
				<ul class="movie_choice">
					<c:forEach var="timetable" items="${list}" varStatus="stat">
					<li> 
						<a href="javascript:getMoviePlayDateList(${timetable.movie_no}, '${timetable.movie_name}');">
							${timetable.movie_name}
						</a>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="rcalendar" class="inner">
			<p class="tit">날짜선택</p>
			<div class="content">
				<div id="calendar_date" class="calendar_top"></div>
				<div id="movieCalendar"></div>
			</div>
		</div>
	</div>
	
	<!-- 좌석 대기 -->
	<div class="reserve_inner i2" id="seat">
		<p class="tit">좌석선택</p>
		<div class="content">
			<p class="screen">스크린</p>
			<form action="reserveComplete.mt" method="post" name="final">
				<input type="hidden" name="time_detail_no" />
				<input type="hidden" name="adult_cnt" />
				<input type="hidden" name="child_cnt" />
				<input type="hidden" name="torrentcal" />
				<input type="hidden" name="total_amount"/>
				<div class="seat" id="selSeatCalc">
					<!-- 좌석 -->
				</div>
			</form>
		</div>
	</div>
	
	<div class="reserve_inner">
		<p class="tit">시간선택</p>
		<div class="content">
			<div id="rtlist">
				<!-- 시간선택 --> 	
			</div>
		</div>
	</div>
	<div class="reserve_inner">
		<p class="tit">인원선택</p>
		<div class="content last">
			<div id="peopleSelect">
				<dl class="ticket" id="cnt_adult">
					<!-- 대인인원수 -->
				</dl>
				<dl class="ticket" id="cnt_child">
					<!-- 소인인원수 -->
				</dl>
			</div>
		</div>
	</div>
	
	<div class="reserve_pic">
		<div id="selMovie"></div>
		<div class="text">
			<p id="selDate"></p>
			<p id="selTime"></p>
			<p id="selAdult"></p>
			<p id="selChild"></p>
			<p id="calcResult"></p>
		</div>
	
		<div class="btn_type_03" id="seatSelection">
			<a href="javascript:SeatSelection('seat');" class="btn btnC_03 btnP_04">
				<span>좌석선택</span>
			</a>
		</div>
		<div class="btn_type_03" id="finalSelection">
			<a href="javascript:SeatSelection('back');" class="btn btnC_03 btnP_04 mr10">
				<span>이전단계</span>
			</a>
			<a href="javascript:finalSelection();" class="btn btnC_04 btnP_04">
				<span>예매완료</span>
			</a>
		</div>
	</div>
</div>