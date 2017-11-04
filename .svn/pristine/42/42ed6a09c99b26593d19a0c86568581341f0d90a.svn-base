<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String cp = request.getContextPath(); %>

<script type="text/javascript">
	function eventDelete(){
		if(confirm("삭제하겠습니까?")){
			location.href='<%=cp %>/admin/adminEventDelete.mt?event_no=${eventModel.event_no}';	
		}
	}
	
</script>

<div id="container">
	<div class="event_view">
		<h3 class="sub_tit">${eventModel.subject}</h3>
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
	</div>
	<div class="btn_type_03">
		<a href="eventList.mt" class="btn btnC_03 btnP_04 mr10">
			<span>목록</span>
		</a>
		<c:if test="${session_member_grade == 1}">
		<a href="<%=cp %>/admin/adminEventUpdate.mt?event_no=${eventModel.event_no}" class="btn btnC_03 btnP_04 mr10">
			<span>수정</span>
		</a><a href="#none" onclick="eventDelete()" class="btn btnC_03 btnP_04">
			<span>삭제</span>
		</a>
		</c:if>
	</div>
	</div>
</div>