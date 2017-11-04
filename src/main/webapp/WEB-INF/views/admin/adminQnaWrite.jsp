<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% String cp = request.getContextPath(); %>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li class="on"><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>

	<div class="admin_ct">
		<h3 class="sub_tit">Q&amp;A 글쓰기</h3>
		<form action="#none" method="post">
			<div class="tbl_type_01">
				<table>
					<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
					<colgroup>
						<col style="width: 120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">글쓴이</th>
							<td>${session_member_name }<input type="hidden"
								class="txt w100" name="name" value="${session_member_name }">
							</td>
						</tr>
						<!-- 					<tr>
							<th scope="row">글쓴이</th>
							<td><input type="text" class="txt w100" name="name" value="admin"/></td>
						</tr> -->
						<tr>
						<th scope="row">비밀번호</th>
						<td><input type="password" class="txt w100" name="passwd"
							value="admin" disabled="disabled" /></td>
						</tr>
						
<!-- 						<tr>
							<th scope="row">비밀번호</th>
							<td><input type="text" class="txt w100" name="passwd" /></td>
						</tr> -->
						<tr>
							<th scope="row">제목</th>
							<td><input type="text" class="txt" name="subject" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="content"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<a href="<%=cp %>/admin/adminQnaList.mt"
					class="btn btnC_03 btnP_04 mr10"> <span>취소</span>
				</a> <span class="btn btnC_04 btnP_04"> <input type="submit"
					value="작성" />
				</span>
			</div>
		</form>
	</div>
</div>