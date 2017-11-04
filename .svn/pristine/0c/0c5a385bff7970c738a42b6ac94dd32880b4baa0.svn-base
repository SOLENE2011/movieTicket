<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Q&amp;A Check</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/import.css" />
<script type="text/javascript">
	function del_chk(){
		var chk = document.getElementById("adminQnaDel");
		chk.method = "post";
		chk.action = "<%=cp %>/admin/adminQnaDelete.mt";
		chk.submit();
	}
</script>
</head>
<body>
	<div class="sign_grp">
		<div class="idpw_grp">
			<h3 class="sub_tit"></h3>
			<form id="adminQnaDel">
				<input type="hidden" name="currentPage" value="${currentPage}"/>
				<input type="hidden" name="qna_no" value="${qna_no}"/>
				<fieldset>
					<legend>비밀번호 확인</legend>
					<div class="tbl_type_01">
						<table>
							<tbody>
								<tr>
									<th scope="row">비밀번호</th>
									<td><input type="password" name="passwd" class="txt w220"/></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="btn_type_04">
						<span class="btn btnC_04 btnF_02">
							<input type="button" value="확인" onclick="del_chk()">
						</span>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>