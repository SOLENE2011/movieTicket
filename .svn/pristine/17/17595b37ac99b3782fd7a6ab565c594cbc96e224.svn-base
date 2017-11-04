<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>

<script type="text/javascript">
	function noticeDelete() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			location.href = 'adminNoticeDelete.mt?no=${noticeModel.no}';
		} else { //취소
			return;
		}
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
		<div class="movie_list">
			<h3 class="sub_tit">공지사항 상세보기</h3>
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
							<td>${noticeModel.name}</td>
						</tr>
						<tr>
							<th scope="row">글제목</th>
							<td>${noticeModel.subject}</td>
						</tr>
						<tr>
							<th scope="row">작성일</th>
							<td><fmt:formatDate value="${noticeModel.regdate}"
									pattern="yyyy.MM.dd" /></td>

						</tr>
						<tr>
							<th scope="row">글내용</th>
							<td><pre>${noticeModel.contents}</pre></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="btn_type_03">
			<a href="#none" class="btn btnC_03 btnP_04 mr10" onclick="location.href='adminNoticeList.mt?currentPage=${currentPage}'">
				<span>목록</span>
			</a>
			<span class="btn btnC_04 btnP_04">
				<input type="button" onclick="location.href='adminNoticeModify.mt?no=${noticeModel.no}'" value="수정" />
			</span>
			<span class="btn btnC_04 btnP_04" style="padding-left: 10px;">
				<input type="button" onclick="noticeDelete()" value="삭제" />
			</span>
		</div>
	</div>
</div>