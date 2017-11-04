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
			<c:if test="${category=='movie'}">		
			{
				movie_no: ${movie.movie_no},
				movie_name: '${movie.movie_name}',  
				director: '${movie.director}', 
				actor: '${movie.actor}', 
				show_date: ${movie.show_date}
			} 			
			</c:if>
			
			<c:if test="${category=='room'}">
			{
				room_no: ${movie.room_no},
				room_name: '${movie.room_name}'
			} 			
			</c:if>
			
			<c:if test="${category=='seat'}">
			{
				seat_no: ${movie.seat_no},
				room_no: ${movie.room_no},
				seat_position: ${movie.seat_position},
				reserved: ${movie.reserved},
				seat_name: '${movie.seat_name}'
			} 			
			</c:if>
			
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
		<message><![CDATA[nodata(ReserveData)]]></message>
	</result> 

</c:otherwise>  
</c:choose>
