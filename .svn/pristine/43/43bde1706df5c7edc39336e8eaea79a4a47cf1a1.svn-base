<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	String cp = request.getContextPath();
%>
<script type="text/javascript" src="<%=cp %>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<div class="admin_grp">
	<div class="admin_list">
		<ul>
			<li><a href="<%=cp%>/admin/movieList.mt">상영작</a></li>
			<li><a href="<%=cp%>/admin/timeTableList.mt">시간표관리</a></li>
			<li class="on"><a href="<%=cp%>/admin/adminMagazineList.mt">매거진</a></li>
			<li><a href="<%=cp%>/admin/adminEventList.mt">이벤트</a></li>
			<li><a href="<%=cp%>/admin/adminNoticeList.mt">공지사항</a></li>
			<li><a href="<%=cp %>/admin/adminQnaList.mt">Q&amp;A</a></li>
			<li><a href="<%=cp%>/admin/memberList.mt">회원정보</a></li>
		</ul>
	</div>
	<div class="admin_ct">
		<h3 class="sub_tit">매거진 수정</h3>
		<form action="adminMagazineUpdate.mt" id="magazineUpdateForm" name="maform" method="post" enctype="multipart/form-data">
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
							<th scope="row">서브제목1</th>
							<td><input type="text" class="txt w200" name="sub_subject1" value="${magazineModel.sub_subject1 }"/></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="content" id="txtContent">${magazineModel.content }</textarea>
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
							<td>
								<input type="file" class="txt" name="image2"  />${magazineModel.image2 }
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<c:if test="${modify != 'true'}">
				<a href="javascript:history.back()" class="btn btnC_03 btnP_04 mr10">
					<span>취소</span>
				</a>
				<span class="btn btnC_04 btnP_04">
					<input type="button" value="수정" onclick="onModify()" />
				</span>
				</c:if>
				<%-- <c:if test="${modify == 'true'}">
				<span class="btn btnC_04 btnP_04">
					<input type="button" value="수정" onclick="onModify()" />
				</span>
				</c:if> --%>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id
	sSkinURI: "<%=cp%>/resources/editor/SmartEditor2Skin.html",  // html editor가 skin url
	fOnAppLoad: function () { 
	    //수정모드를 구현할 때 사용할 부분. 로딩이 끝난 후 값이 체워지게 하는 구현을 하면 된다.
	     var title = '${magazineModify.subject}';               
	     var content = '${magazineModify.content}';         //db에서 불러온 값을 여기에서 체워넣으면 됨.
	     document.getElementById("subject").value = title;     
	     oEditors.getById["txtContent"].exec("PASTE_HTML", [content]); //로딩이 끝나면 contents를 txtContent에 넣음
	 },
	 fCreator: "createSEditor2"
});

/* var onWrite = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var magazineWriteForm = document.getElementById("magazineWriteForm");  
	magazineWriteForm.action ="adminMagazineUpdate.mt";              
	magazineWriteForm.submit();  
}; */

var onModify = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var magazineWriteForm = document.getElementById("magazineUpdateForm");  
	magazineWriteForm.action ="adminMagazineUpdate.mt?magazine_no=${magazineModify.magazine_no}";              
	magazineWriteForm.submit();  
};

var pasteHTML = function(filename){                     //업로드한 사진을 화면에 보여주게 만드는 스크립트입니다.
	var sHTML = '<img src="${pageContext.request.contextPath}/upload/editor_img/'+filename+'">'; //사진이 저장된 경로입니다.
	oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
	};
</script>