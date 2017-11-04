<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

	window.onload = function(){
		var chk = ${modifyCheck}
		if(chk == 1){
			alert('글이 수정되었습니다.');
			document.form1.submit();
			//window.location.href = '/project/qna/qnaView.mt?qna_no=${qna_no}&currentPage=${currentPage}';
			//opener.parent.location.reload();
			//self.close();
		}
		if(chk == -1){
			alert('비밀번호가 틀렸습니다');
			history.back();
		}
	}
</script>
<html>
<head>
</head>
<body>
	<form action="/project/qna/qnaModify.mt" method="post" name="form1">
		<input type="hidden" name="qna_no" value="${qnaModel.qna_no}">
		<input type="hidden" name="name" value="${qnaModel.name}" />
		<input type="hidden" name="subject" value="${qnaModel.subject}"/>
		<input type="hidden" name="content" value="${qnaModel.content}">
	</form>
</body>

</html>
