<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<form action="" method="post" enctype="multipart/form-data">
			<div class="tbl_type_01">
				<c:forEach var="list" items="${list}" varStatus="stat">
					<input type="hidden" name="movie_no" value="${list.movie_no}">
					<table>
						<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
						<colgroup>
							<col style="width: 120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">영화제목</th>
								<td><input type="text" class="txt w200" name="movie_name" value="${list.movie_name}"/></td>
							</tr>
							<tr>
								<th scope="row">감독</th>
								<td><input type="text" class="txt w200" name="director" value="${list.director}"/></td>
							</tr>
							<tr>
								<th scope="row">배우</th>
								<td><input type="text" class="txt w200" name="actor" value="${list.actor}"/></td>
							</tr>
							<tr>
								<th scope="row">개봉일</th>
								<td>
									
									<input type="text" class="txt w200" name="date" value="<fmt:formatDate value="${list.show_date }" pattern="yyyyMMdd"></fmt:formatDate>"/>
									<span class="ibk">예)20160606</span>
								</td>
							</tr>
							<tr>
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="story">${list.story}</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">포스터</th>
								<td>
									<input type="file" class="txt" name="poster" />
									<input type="hidden" name="poster_old" value="${list.poster}">
									<c:if test="${list.poster != '사진없음'}">
										사진이 이미 등록되어있습니다. 새로 등록하시면 기존 이미지와 대체됩니다.
									</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">스틸컷 1</th>
								<td>
									<input type="file" class="txt" name="cut1" />
									<input type="hidden" name="cut1_old" value="${list.cut1}">
									<c:if test="${list.cut1 != '사진없음'}">
										사진이 이미 등록되어있습니다. 새로 등록하시면 기존 이미지와 대체됩니다.
									</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">스틸컷 2</th>
								<td>
									<input type="file" class="txt" name="cut2" />
									<input type="hidden" name="cut2_old" value="${list.cut2}">
									<c:if test="${list.cut2 != '사진없음'}">
										사진이 이미 등록되어있습니다. 새로 등록하시면 기존 이미지와 대체됩니다.
									</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">스틸컷 3</th>
								<td>
									<input type="file" class="txt" name="cut3" />
									<input type="hidden" name="cut3_old" value="${list.cut3}">
									<c:if test="${list.cut3 != '사진없음'}">
										사진이 이미 등록되어있습니다. 새로 등록하시면 기존 이미지와 대체됩니다.
									</c:if>
								</td>
							</tr>
							<tr>
								<th scope="row">장르</th>
								<td><input type="text" class="txt w200" name="summary" value="${list.summary}"/></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_04 btnP_04"> <input type="submit"
					value="작성완료" />
				</span>

			</div>
		</form>
	</div>
</div>