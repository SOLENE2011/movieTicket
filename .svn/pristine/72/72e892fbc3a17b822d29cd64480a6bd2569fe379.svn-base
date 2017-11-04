<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div id="container_admin">
	<div class="admin_grp">
		<div class="admin_list">
			<ul>
				<li class="on"><a href="admin_01.html">상영작</a></li>
				<li><a href="admin_05.html">시간표관리</a></li>
				<li><a href="admin_02.html">매거진</a></li>
				<li><a href="#none">이벤트</a></li>
				<li><a href="admin_03.html">공지사항</a></li>
				<li><a href="#none">QnA</a></li>
				<li><a href="admin_04.html">회원정보</a></li>
			</ul>
		</div>
		<div class="admin_ct">
			<h3 class="sub_tit">매거진 수정</h3>
			<form action="magazineUpdate.mt" name="maform" method="post" enctype="multipart/form-data">
			<%-- <form commandName="magazineModel" action="magazineWrite.mt" name="maform" method="post" enctype="multipart/form-data"> --%>
				<%-- <input type="hidden" name="currentPage" value="${currentPage}" />--%>
				<input type="hidden" name="magazine_no" value="${magazineModel.magazine_no}" />
				<%-- <input type="hidden" name="subject" value="${magazineModel.subject}"/>
				<input type="hidden" name="subject2" value="${magazineModel.subject2 }"/>
				<input type="hidden" name="content" value="${magazineModel.content }"/>--%>
				<input type="hidden" name="image1" value="${magazineModel.image1 }"/>
				<input type="hidden" name="image2" value="${magazineModel.image2 }"/>
				
			<%-- <%-- <form:form action="magazineList.mt" method="post"> --%> 
				<div class="tbl_type_01">
					<table>
						<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
						<colgroup>
							<col style="width:120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">제목</th>
								<td><input type="text" class="txt w200" name="subject" value="${magazineModel.subject }"/></td>
							</tr>
							<tr>
								<th scope="row">제목2</th>
								<td><input type="text" class="txt w200" name="subject2" value="${magazineModel.subject2 }"/></td>
							</tr>
							<tr>
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="content" >${magazineModel.content }</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">서브제목1</th>
								<td><input type="text" class="txt w200" name="sub_subject1" value="${magazineModel.sub_subject1 }"/></td>
							</tr>
							<tr>
								<th scope="row">서브내용1</th>
								<td>
									<div class="textarea_grp">
										<textarea name="sub_content1" >${magazineModel.sub_content1 }</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">서브제목2</th>
								<td><input type="text" class="txt w200" name="sub_subject2" value="${magazineModel.sub_subject2 }"/></td>
							</tr>
							<tr>
								<th scope="row">서브내용2</th>
								<td>
									<div class="textarea_grp">
										<textarea name="sub_content2" >${magazineModel.sub_content2 }</textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">섬네일이미지1</th>
								<td><input type="file" class="txt" name="image1"  />${magazineModel.image1 }</td>
							</tr>
							<tr>
								<th scope="row">섬네일이미지2</th>
								<td><input type="file" class="txt" name="image2"  />${magazineModel.image2 }
									<!-- <input type="hidden" name="reg_date" value="20160801"/> -->
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_type_03">
					<span class="btn btnC_04 btnP_04">
						<input type="submit" value="등록완료" />
					</span>
				</div>
			</form>
		</div>
	</div>
</div><!-- // container -->
