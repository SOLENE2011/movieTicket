<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

	window.onload = function(){
		var chk = ${rollback}
		if(chk == 0){
			var r = confirm("위시리스트에 담겼습니다. 마이페이지에서 확인하시겠습니까?");
			if (r == true) {
			    window.location.href = '/project/mypage/wishList_Success.mt?movie_no=${movie_no}&currentPage=${currentPage}&gomypage=1';
			} else {
				window.location.href = '/project/mypage/wishList_Success.mt?movie_no=${movie_no}&currentPage=${currentPage}&gomypage=0';
			}
			//document.form1.submit();
		}
		if(chk == 1){
			alert('로그인을 하셔야 사용할 수 있습니다.');
			history.back();
		}
	}
</script>
