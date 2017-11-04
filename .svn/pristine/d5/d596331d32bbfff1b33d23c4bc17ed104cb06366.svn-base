<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<%
	String cp = request.getContextPath();
%>


<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li class="on"><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<h3 class="sub_tit">상영작 등록</h3>
		<form:form action="" method="post" enctype="multipart/form-data" modelAttribute="movieModel">
			<div class="tbl_type_01">
				<table>
					<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
					<colgroup>
						<col style="width: 120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">영화제목</th>
							<td>
								<form:input type="text" class="txt w200" path="movie_name" />
								<font color="red"><form:errors path="movie_name"/></font>
							</td>
						</tr>
						<tr>
							<th scope="row">감독</th>
							<td>
								<form:input type="text" class="txt w200" path="director" />
								<font color="red"><form:errors path="director"/></font>
							</td>
						</tr>
						<tr>
							<th scope="row">배우</th>
							<td>
								<form:input type="text" class="txt w200" path="actor" />
								<font color="red"><form:errors path="actor"/></font>
							</td>
						</tr>
						<tr>
							<th scope="row">개봉일</th>
							<td>
								<form:input type="text" class="txt w200" path="show_date" />
								<span class="ibk">예)20160606</span>
								<font color="red"><form:errors path="show_date"/></font>
							</td>
						</tr>
						<tr>
							<th scope="row">줄거리</th>
							<td>
								<div class="textarea_grp">
									<textarea name="story"></textarea>
								</div>
								<font color="red"><form:errors path="story"/></font>
							</td>
						</tr>
						<tr>
							<th scope="row">포스터</th>
							<td>
								<input type="file" class="txt" name="poster" />
							</td>
						</tr>
						<tr>
							<th scope="row">스틸컷 1</th>
							<td><input type="file" class="txt" name="cut1" /></td>
						</tr>
						<tr>
							<th scope="row">스틸컷 2</th>
							<td><input type="file" class="txt" name="cut2" /></td>
						</tr>
						<tr>
							<th scope="row">스틸컷 2</th>
							<td><input type="file" class="txt" name="cut3" /></td>
						</tr>
						<tr>
							<th scope="row">개요</th>
							<td>
								<form:input type="text" class="txt w200" path="summary" />
								<font color="red"><form:errors path="summary"/></font>
								<span class="ibk">예)모험, 드라마 [미국] 106분</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_04 btnP_04"> <input type="submit"
					value="작성완료" />
				</span>
			</div>
		</form:form>
	</div>
</div>