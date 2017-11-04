<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String cp = request.getContextPath();
%>
<script type="text/javascript">
	function validation1(){
		var frm = document.forms1;
		
		if(frm.subject.value == ""){
			alert("제목을 입력해주세요.");
			frm.subject.focus();
			return false;
		}
		else if(frm.contents.value == ""){
			alert("내용을 입력해주세요.");
			frm.contents.focus();
			return false;
		}
		return true;
	}
</script>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<form action="adminNoticeWrite.mt" method="post" name="forms1" onsubmit="return validation1();">
			<div class="tbl_type_01">
				<table>
					<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
					<colgroup>
						<col style="width:120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">글쓴이</th>
							<td>${session_member_name }
								<input type="hidden" name="name" value="${session_member_name }">
							</td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td><input type="text" name="subject" class="txt w200" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="contents"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<a href="javascript:history.back()" class="btn btnC_03 btnP_04 mr10">
					<span>목록</span>
				</a>
				<span class="btn btnC_04 btnP_04">
					<input type="submit" value="등록완료"/>
				</span>
			</div>
		</form>		
	</div>
</div>