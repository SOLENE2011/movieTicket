<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String cp = request.getContextPath();
%>
<script type="text/javascript">
	function eventDelete1(){
		if(confirm("삭제하겠습니까?")){
			location.href='adminEventDelete.mt?event_no=${eventModel.event_no}';	
		}
	}
	
	
</script>

<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<div class="movie_list">
			<h3 class="sub_tit">${eventModel.subject}</h3>
			<!-- <div class="inner"> 아래부터 에디터로 바꾸어야 할 부분
				<img src="/project/images/event_view.jpg" alt="이벤트 뷰" />
			</div> -->
			<div class="terms_ct">
				<div class="tbl_type_01">
					<table>
						<caption>내용 표</caption>
						<colgroup>
							<col style="width:120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">내용</th>
								<td>
									<p class="line_p">${eventModel.content}</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div><!-- // event_list -->
		</div>
		<div class="btn_type_03">
			<a href="adminEventList.mt" class="btn btnC_03 btnP_04 mr10">
				<span>목록</span>
			</a>
			<a href="adminEventUpdate.mt?event_no=${eventModel.event_no}" class="btn btnC_03 btnP_04 mr10">
				<span>수정</span>
			</a><a href="#none" onclick="eventDelete1()" class="btn btnC_03 btnP_04">
				<span>삭제</span>
			</a>
		</div>
	</div>
</div>