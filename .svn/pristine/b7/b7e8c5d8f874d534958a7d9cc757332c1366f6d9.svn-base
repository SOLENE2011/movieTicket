<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<script type="text/javascript" src="<%=cp %>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>

<div class="terms_grp">
	<div class="terms_ct">
		<h3 class="sub_tit">자유게시판</h3>
		<form action="#none" method="post" id="boardWriteForm">
			<div class="tbl_type_01">
				<table>
					<caption>제목,내용을 나타내는 자유게시판</caption>
					<colgroup>
						<col style="width:120px;" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">이름</th>
							<td>
								${session_member_name}
								<input type="hidden" name="name" value="${session_member_name}" />
							</td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td><input type="text" class="txt" name="subject" id="subject" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="contents" id="txtContent"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<a href="<%=cp %>/free/freeBoardList.mt" class="btn btnC_03 btnP_04 mr10">
					<span>취소</span>
				</a>
				<c:if test="${modify != 'true'}">
				<span class="btn btnC_04 btnP_04">
					<input type="button" value="작성" onclick="onWrite()" />
				</span>
				</c:if>
				<c:if test="${modify == 'true'}">
				<span class="btn btnC_04 btnP_04">
					<input type="button" value="수정" onclick="onModify()" />
				</span>
				</c:if>
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
         var title = '${freeModify.subject}';               
         var contents = '${freeModify.contents}';         //db에서 불러온 값을 여기에서 체워넣으면 됨.
         document.getElementById("subject").value = title;     
         oEditors.getById["txtContent"].exec("PASTE_HTML", [contents]); //로딩이 끝나면 contents를 txtContent에 넣음
     },
     fCreator: "createSEditor2"
 });

var onWrite = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var boardWriteForm = document.getElementById("boardWriteForm");  
	boardWriteForm.action ="freeBoardWrite.mt";              
	boardWriteForm.submit();  
};

var onModify = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var boardWriteForm = document.getElementById("boardWriteForm");  
	boardWriteForm.action ="freeBoardModify.mt?free_no=${freeModify.free_no}";              
	boardWriteForm.submit();  
};

var pasteHTML = function(filename){                     //업로드한 사진을 화면에 보여주게 만드는 스크립트입니다.
    var sHTML = '<img src="${pageContext.request.contextPath}/upload/editor_img/'+filename+'">'; //사진이 저장된 경로입니다.
    oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
};

</script>