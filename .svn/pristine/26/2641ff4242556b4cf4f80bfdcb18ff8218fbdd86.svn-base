<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String cp = request.getContextPath();
%>
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/jquery-ui.css" />

<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<form:form commandName="eventModel" action="adminEventWrite.mt" enctype="multipart/form-data" method="post"  name="eventWriteForm" onsubmit="return validation1();">
		<div class="movie_list">
			<h3 class="sub_tit">이벤트 등록</h3>
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
									<input type="text" name="subject" id="subject" class="txt w200"/>
								</td>
							</tr>
							<tr> <!-- 리스트에 보여질 이미지 -->
								<th scope="row">이미지</th>
								<td>
									<input type="file" name="image1" class="txt" />
								</td>
							</tr>
							<tr> <!-- 에디터로 바꾸어야 할 부분 -->
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="content" id="txtContent"></textarea>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">시작일</th>
								<td>
									<input type="text" name="e_start_date" id="e_start_date" class="txt w200"/>
								</td>
							</tr>
							<tr>
								<th scope="row">종료일</th>
								<td>
									<input type="text" name="e_end_date" id="e_end_date" class="txt w200"/>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		<div class="btn_type_03">
			<a href="javascript:history.back()" class="btn btnC_03 btnP_04 mr10"> <!-- javascript:history.back() 뒤로 가기 스크립트에 따로 선언 없이 할 수 있음 -->
				<span>취소</span>
			</a>
			<span class="btn btnC_04 btnP_04">
				<input type="submit" value="등록완료" onclick="onWrite()"/>
			</span>
		</div>
		</form:form>
	</div>
</div>

<script type="text/javascript" src="<%= cp %>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=cp %>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">

	function validation1(){
		var frm = document.eventWriteForm;
		
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
			alert("시작일를 입력해주세요.");
			frm.e_start_date.focus();
			return false;
		}
		
		else if(frm.e_end_date.value == ""){
			alert("종료일를 입력해주세요.");
			frm.e_end_date.focus();
			return false;
		}
		return true;
	}
	
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id
		sSkinURI: "<%=cp%>/resources/editor/SmartEditor2Skin.html", // html editor가 skin url
		fOnAppLoad: function(){
			//수정모드를 구현할 때 사용할 부분. 로딩이 끝난 후 값이 체워지게 하는 구현을 하면 된다.
			
			var title = '${eventModel.subject}';
			var content = '${eventModel.content}'; //db에서 불러온 값을 여기에서 체워넣으면 됨.
			
			document.getElementById("subject").value = title;
			oEditors.getById["txtContent"].exec("PASTE_HTML", [content]); //로딩이 끝나면 contents를 txtContent에 넣음
		},
		fCreator: "createSEditor2"
	});
	
	var onWrite = function(){
		oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
		var eventWriteForm = document.getElementById("eventWriteForm");
		eventWriteForm.action = "adminEventWrite.mt";
		eventWriteForm.submit();
	};
	
	var onModify = function(){
		oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
		var eventWriteForm = document.getElementById("eventWriteForm");
		eventWriteForm.action="adminEventUpdate.mt?event_no=${eventModel.event_no}";
		eventWriteForm.submit();
	};
	//업로드한 사진을 화면에 보여주게 만드는 스크립트입니다.
	var pasteHTML = function(filename){ 
		var sHTML = '<img src="${pageContext.request.contextPath}/upload/editor_img/'+filename+'">'; //사진이 저장된 경로입니다.
		oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
	};
	
	$(function(){
		$('#e_start_date').datepicker();
		$('#e_end_date').datepicker();
	})
</script>


