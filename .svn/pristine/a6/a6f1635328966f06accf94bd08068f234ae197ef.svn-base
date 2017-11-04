<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
<c:when test="${fn:length(timeDetailList) gt 0}">

	<result>
		<code>success</code>
		<data><![CDATA[
		[
		
		<c:forEach var="timeDetail" items="${timeDetailList}" varStatus="stat">
			{
				time_detail_no: ${timeDetail.time_detail_no},
				time_no: ${timeDetail.time_no},  
				time_name: '${timeDetail.time_name}', 
				show_date: '${timeDetail.show_date}',
				start_time: '${timeDetail.start_time}',
				end_time: '${timeDetail.end_time}',
				total_seat: ${timeDetail.total_seat},
				reserved_seat: ${timeDetail.reserved_seat},
				adult_amt: ${timeDetail.adult_amt},
				child_amt: ${timeDetail.child_amt}
			} 
			
			<c:if test="${(fn:length(timeDetailList)-1) != stat.index}">
			,
			</c:if>
			
		</c:forEach>
		]
		]]></data>
	</result>

</c:when>
<c:otherwise>

	<result>
		<code>error</code>
		<message><![CDATA[nodata(Timedetail_Data)]]></message>
	</result> 

</c:otherwise> 
</c:choose>