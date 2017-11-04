<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String cp = request.getContextPath();
%>

<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieWrite.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/magazineWrite.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/eventWrite.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/noticeWrite.mt">공지사항</a></li>
			<li class="on"><a href="<%=cp%>/admin/qnaList.mt">QnA</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>

	<div class="admin_ct">
		<h3 class="sub_tit">Q&A Reply</h3>
		<form action="<%=cp%>/admin/adminQnaReplySuccess.mt"  method="post">
			<input type="hidden" name="qna_no" value="${qnaModel.qna_no}" /> 
			<input type="hidden" name="currentPage" value="${currentPage}" />
			<div class="tbl_type_01">
				<table>
					<caption>번호,제목,글쓴이,날짜,조회를 나타내는 Q&A 표</caption>
					<colgroup>
						<col style="width: 120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">글쓴이</th>
							<td>
								${session_member_name }
								<input type="hidden" name="name" value="${session_member_name }">
							</td>
						</tr>
						<tr>
							<th scope="row">패스워드</th>
							<td>
								<input type="password" class="txt" name="passwd"  value="0000" disabled="disabled"/>
							</td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td>
								<input type="text" class="txt" name="subject" value="[답변]${qnaModel.subject }" />
								<font color="red"><form:errors path="subject" /></font>
							</td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="content" cols="50" rows="10">
												${qnaModel.content}
									</textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_03 btnP_04 mr10" onclick="history.go(-1);">
					<input type="button" value="취소" />
				</span> 
				<span class="btn btnC_04 btnP_04"> 
					<input type="submit" value="작성" />
				</span>
			</div>
		</form>
	</div>
</div>

