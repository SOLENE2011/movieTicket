<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	function validation(){
		var frm = document.forms;
		
		if(frm.subject.value == ""){
			alert("제목을 입력해주세요.");
			frm.subject.focus();
			return false;
		}
		else if(frm.image1.value == ""){
			alert("이미지를 넣어주세요.");
			frm.image1.focus();
			return false;
		}
		
		else if(frm.content.value == ""){
			alert("내용을 입력해주세요.");
			frm.content.focus();
			return false;
		}
		
		else if(frm.e_start_date.value == ""){
			alert("시작일를 입력해주세요. 예) 2016.06.14");
			frm.e_start_date.focus();
			return false;
		}
		
		else if(frm.e_end_date.value == ""){
			alert("종료일를 입력해주세요. 예) 2016.06.14");
			frm.e_end_date.focus();
			return false;
		}
		return true;
	}
</script>

	<div class="admin_grp">
		<div class="admin_list">
			<ul>
				<li><a href="admin_01.html">상영작</a></li>
				<li><a href="admin_05.html">시간표관리</a></li>
				<li><a href="admin_02.html">매거진</a></li>
				<li class="on"><a href="eventWrite.mt">이벤트</a></li>
				<li><a href="admin_03.html">공지사항</a></li>
				<li><a href="#none">QnA</a></li>
				<li><a href="admin_04.html">회원정보</a></li>
			</ul>
		</div>
		<div class="admin_ct">
			<h3 class="sub_tit">이벤트 등록</h3>
			<form:form commandName="eventModel" action="eventWrite.mt" enctype="multipart/form-data" method="post" name="forms" onsubmit="return validation();">
				<input type="hidden" name="event_no" value="${eventModel.event_no}"/>
				<input type="hidden" name="currentPage" value="${currentPage}"/>
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
								<td>
									<input type="text" name="subject" class="txt w200"/>
									<font color="red"><form:errors path="subject"/></font>
								</td>
							</tr>
							<tr> <!-- 리스트에 보여질 이미지 -->
								<th scope="row">이미지</th>
								<td>
									<input type="file" name="image1" class="txt" />
									<%-- <font color="red"><form:errors path="image1"/></font> --%>
								</td>
							</tr>
							<tr> <!-- 에디터로 바꾸어야 할 부분 -->
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="content"></textarea>
										<font color="red"><form:errors path="content"/></font>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">시작일</th>
								<td>
									<input type="text" name="e_start_date" class="txt w200"/>예) 2016.06.14
									<%-- <font color="red"><form:errors path="e_start_date"/></font> --%>
								</td>
							</tr>
							<tr>
								<th scope="row">종료일</th>
								<td>
									<input type="text" name="e_end_date" class="txt w200"/>예) 2016.06.14
									<%-- <font color="red"><form:errors path="e_end_date"/></font> --%>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_type_03">
					<span class="btn btnC_04 btnP_04">
						<input type="submit" value="등록완료"/>
					</span>
				</div>
			</form:form>
		</div>
	</div>
