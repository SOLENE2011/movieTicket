<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
<c:when test="${fn:length(list) gt 0}">

	<result>
		<code>success</code>
		<data><![CDATA[
		[
		<c:forEach var="movie" items="${list}" varStatus="stat">
			{
				movie_no: ${movie.movie_no},
				room_no: '${movie.room_no}',
				time_no: '${movie.time_no}',
				time_detail_no: '${movie.time_detail_no}',
				movie_name: '${movie.movie_name}',
				room_name: '${movie.room_name}',
				time_name: '${movie.time_name}',
				show_date: '${movie.show_date}',
				start_time: '${movie.start_time}',
				end_time: '${movie.end_time}',
				start_date: '${movie.start_date}',
				end_date: '${movie.end_date}',
				total_seat: ${movie.total_seat},
				reserved_seat: ${movie.reserved_seat},
				adult_amt: ${movie.adult_amt},
				child_amt: ${movie.child_amt}
			} 
			<c:if test="${(fn:length(list)-1) != stat.index}">
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
		<message><![CDATA[nodata(TimeTableData)]]></message>
	</result> 
</c:otherwise>

</c:choose>
