<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String cp = request.getContextPath(); %>
<script type="text/javascript" src="<%=cp %>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	function validation(){
		var frm=document.frms;
		if(frm.subject.value == ""){
			alert("제목을 입력해주세요.");
			frm.subject.focus();
			return false;
		}
		else if(frm.subject2.value == ""){
			alert("제목2를 넣어주세요.");
			frm.subject2.focus();
			return false;
		}
		else if(frm.content.value == ""){
			alert("내용을 입력해주세요.");
			frm.content.focus();
			return false;
		}
		else if(frm.sub_subject1.value == ""){
			alert("서브젝트1을 입력해주세요.");
			frm.sub_subject1.focus();
			return false;
		}
		else if(frm.sub_content1.value == ""){
			alert("서브내용1을 입력해주세요.");
			frm.sub_content1.focus();
			return false;
		}
		else if(frm.sub_subject2.value == ""){
			alert("서브젝트2을 입력해주세요.");
			frm.sub_subject2.focus();
			return false;
		}
		else if(frm.sub_content2.value == ""){
			alert("서브내용2을 입력해주세요.");
			frm.sub_content2.focus();
			return false;
		}
		else if(frm.image1.value == ""){
			alert("이미지를 넣어주세요.");
			frm.image1.focus();
			return false;
		}
		else if(frm.image2.value == ""){
			alert("이미지를 넣어주세요.");
			frm.image2.focus();
			return false;
		}
		return true;
	}
	
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: document.getElementById('txtContent'), // html editor가 들어갈 textarea id
	sSkinURI: "<%=cp%>/resources/editor/SmartEditor2Skin.html",  // html editor가 skin url
	fOnAppLoad: function () { 
        //수정모드를 구현할 때 사용할 부분. 로딩이 끝난 후 값이 체워지게 하는 구현을 하면 된다.
         var title = '${adminMagazineUpdate.subject}';  
         var subject2 = '${adminMagazineUpdate.subject2}';   
         var content = '${adminMagazineUpdate.content}';         //db에서 불러온 값을 여기에서 체워넣으면 됨.
         document.getElementById("subject").value = title;     
         oEditors.getById["txtContent"].exec("PASTE_HTML", [content]); //로딩이 끝나면 contents를 txtContent에 넣음
     },
     fCreator: "createSEditor2"
 });

var onWrite = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var adminMagazineWrite = document.getElementById("magazineWrite");  
	magazineWrite.action ="adminMagazineWrite.mt";              
	magazineWrite.submit();  
};

/* var onModify = function(){
	oEditors.getById["txtContent"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됨
	var magazineWrite = document.getElementById("magazineWrite");  
	magazineWrite.action ="adminMagazineUpdate.mt?magazine_no=${MagazineModel.magazine_no}";              
	magazineWrite.submit();  
};
 */
/* var pasteHTML = function(filename){                     //업로드한 사진을 화면에 보여주게 만드는 스크립트입니다.
    var sHTML = '<img src="${pageContext.request.contextPath}/upload/editor_img/'+filename+'">'; //사진이 저장된 경로입니다.
    oEditors.getById["txtContent"].exec("PASTE_HTML", [sHTML]);
};  */
	
</script>
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
			<h3 class="sub_tit">매거진 등록</h3>
			<form:form action="#none" id="magazineWrite" method="post" enctype="multipart/form-data" name="frms" onsubmit="return validation();">
			<%-- <form commandName="magazineModel" action="magazineWrite.mt" name="maform" method="post" enctype="multipart/form-data"> --%>
				<input type="hidden" name="currentPage" value="${currentPage}" />
				<input type="hidden" name="magazine_no" value="${magazineView.magazine_no}" /> 
				
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
								<td><input type="text" name="subject" class="txt w200"/>
									 <form:errors path="subject"/></td>
							</tr>
							<tr>
								<th scope="row">제목2</th>
								<td><input type="text" name="subject2" class="txt w200"/>
									<form:errors path="subject2"/></td>
							</tr>
							<tr>
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="content" id="txtContent"></textarea>
										<form:errors path="content"/>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">서브제목1</th>
								<td><input type="text" name="sub_subject1" class="txt w200"/>
									<form:errors path="sub_subject1"/></td>
							</tr>
							<tr>
								<th scope="row">서브내용1</th>
								<td>
									<div class="textarea_grp">
										<textarea name="sub_content1"></textarea>
										<form:errors path="sub_content1"/>
									</div>
								</td>
							</tr>
								<tr>
								<th scope="row">서브제목2</th>
								<td><input type="text" name="sub_subject2" class="txt w200"/>
									<form:errors path="sub_subject2"/></td>
							</tr>
							<tr>
								<th scope="row">서브내용2</th>
								<td>
									<div class="textarea_grp">
										<textarea name="sub_content2"></textarea>
										<form:errors path="sub_content2"/>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">섬네일이미지1</th>
								<td><input type="file" class="txt" name="image1" /></td>
							</tr>
							<tr>
								<th scope="row">섬네일이미지2</th>
								<td><input type="file" class="txt" name="image2"/>
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				<div class="btn_type_03">
					<c:if test="${modify != 'true'}">
					<span class="btn btnC_04 btnP_04">
						<input type="button" value="등록완료" onclick="onWrite()"/>
					</span>
					</c:if>
					<c:if test="${modify == 'true'}">
						<span class="btn btnC_04 btnP_04">
								<input type="button" value="수정" onclick="onModify()" />
						</span>
					</c:if>
				</div>
			</form:form>
		</div>
	</div>
</div><!-- // container -->
