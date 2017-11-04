<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<title>댓글삭제</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/import.css" />
<script type="text/javascript">
	function del_chk(){
		//window.opener.document.commentDelete.receiver.value = document.commentDelete.sender.value;
		var chk = document.getElementById("commentDel");
		chk.method = "post";
		chk.action = "<%=cp %>/magazine/commentDelete.mt";
		chk.submit();
		
		
		//opener.parent.location.reload();
		//window.close();
		
	}
</script>
</head>
<body>
	<div class="sign_grp">
		<div class="idpw_grp">
			<h3 class="sub_tit"></h3>
			<form id="commentDel">
				<input type="hidden" name="currentPage" value="${currentPage}"/>
				<input type="hidden" name="mcomment_no" value="${mcomment_no}"/>
				<input type="hidden" name="magazine_no" value="${magazine_no}"/>

				<fieldset>
					<legend>비밀번호 확인</legend>
					<div class="tbl_type_01">
						<table>
							<tbody>
								<tr>
									<th scope="row">비밀번호</th>
									<td><input type="password" name="password" class="txt w220"/></td>
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