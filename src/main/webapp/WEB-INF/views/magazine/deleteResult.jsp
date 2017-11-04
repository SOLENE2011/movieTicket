<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

	window.onload = function(){
		var chk = ${deleteCheck}
		if(chk == 1){
			alert('댓글이 삭제되었습니다.');
			window.location.href = '/project/magazine/magazineView.mt?magazine_no=${magazine_no}&currentPage=${currentPage}';
			opener.parent.location.reload();
			self.close();
		}
		if(chk == -1){
			alert('비밀번호가 틀렸습니다');
			history.back();
		}
	}
</script>