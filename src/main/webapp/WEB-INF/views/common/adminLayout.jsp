<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>MovieTicketAdmin</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/import.css" />
<script src="<%= cp %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= cp %>/js/common.js"></script>
</head>
<body>
<div id="wrap">

	<!-- header -->
	<div id="header_admin">
		<tiles:insertAttribute name="header" />
	</div><!-- // header -->
	
	<!-- container -->
	<div id="container_admin">
		<tiles:insertAttribute name="body" />
	</div><!-- // container -->
	
	<!-- footer -->
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div><!-- // footer -->
	
</div><!-- // wrap -->
</body>
</html>