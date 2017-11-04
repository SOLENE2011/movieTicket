<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String cp = request.getContextPath(); %>

<div class="terms_grp">
	<div class="terms_ct">
		<h3 class="sub_tit">자유게시판 상세보기</h3>
		<div class="tbl_type_01">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
				<colgroup>
					<col style="width: 120px;" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">작성자</th>
						<td>${freeBoard.name}</td>
					</tr>
					<tr>
						<th scope="row">글제목</th>
						<td>${freeBoard.subject}</td>
					</tr>
					<tr>
						<th scope="row">작성일</th>
						<td><fmt:formatDate value="${freeBoard.reg_date}" pattern="yyyy.MM.dd" /></td>
					</tr>
					<tr>
						<th scope="row">글내용</th>
						<td class="contents_img">${freeBoard.contents}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn_type_03">
			<a href="<%=cp %>/free/freeBoardList.mt" class="btn btnC_03 btnP_04 mr10">
				<span>목록</span>
			</a>
			<form class="viewForm mr10 inblock" method="post">
				<span class="btn btnC_04 btnP_04">
					<input type="button" value="수정" onclick="onModify()" />
				</span>	
			</form>
			<span class="btn btnC_04 btnP_04">
				<input type="button" value="삭제" onclick="onDelete()"/>
			</span>
		</div>
	</div>
</div>

<script type="text/javascript">
	var onModify = function(){
		var form = $('.viewForm')[0];
		form.action = 'freeBoardModifyForm.mt?free_no=${freeBoard.free_no}';
		form.submit();
	}
	
	function onDelete(){
		if(confirm("삭제하시겠습니까?")){
			location.href = 'freeBoardDelete.mt?free_no=${freeBoard.free_no}';
		}
	}
</script>
</html>