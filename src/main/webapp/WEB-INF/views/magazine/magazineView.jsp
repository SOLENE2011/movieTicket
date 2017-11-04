<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String cp = request.getContextPath(); %>


<script type="text/javascript">
	function del_check(url) {		
		if (confirm("삭제 하겠습니까?")) {	
			location.href = url;
		}
	}
	
	jQuery.fn.center = function () {
  	    this.css("position","absolute");
  	    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
  	    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
  	    return this;
  	}
	
	function openComment(url){
		cw=screen.availWidth;     //화면 넓이
		ch=screen.availHeight;    //화면 높이
	
		sw=500;    //띄울 창의 넓이
		sh=400;    //띄울 창의 높이
	
		ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		mt=(ch-sh)/2;        //가운데 띄우기위한 창의 y위치
		window.open(url, "confirm","width="+sw+", height="+sh+",top="+mt+", left="+ml+", toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no");
	}
	function validation(){
		var comment = document.cfrms;
		if(comment.name.value == ""){
			alert("이름을 입력해주세요.");
			comment.name.focus();
			return false;
		}else if(comment.password.value == ""){
			alert("비밀번호를 넣어주세요.");
			comment.password.focus();
			return false;
		}else if(comment.content.value == ""){
			alert("내용을 입력해주세요.");
			comment.content.focus();
			return false;
		}
		return true;
	}
	
	/* function open_win_noresizable(url,name){
		var oWin=window.open(url,name,"scrollbars=no,status=no,resizable=no,width=380,height=230");
	} */
 
</script>
	<div class="magazine_grp">
		<h3 class="sub_tit">${magazine.subject }</h3>
		<div class="magazine_view">
			<p class="view_main"><img src="/project/upload/magazine/${magazine.image2 }"  /></p>
			<div class="view_steel">
				<p class="tit">${magazine.sub_subject1 }</p>
				<p class="steel_txt">${magazine.content }</p>
			</div>
			<div class="view_steel">
				<p class="tit">${magazine.sub_subject2 }</p>
				<p class="steel_txt">${magazine.sub_content2 }</p>
			</div>
		</div>
	

		<!-- reply_grp -->
		
		<div class="reply_grp">
			<form:form action="commentWrite.mt" method="post" name="cfrms" onsubmit="return validation();">
			<div class="reply_form">
				<div class="reply_inp">
					<input type="hidden" name="magazine_no" value="${magazine.magazine_no}"/>
					<input type="hidden" name="currentPage" value="${currentPage}"/>
					<input type="hidden" name="currentPage2" value="${currentPage2}"/>
					<c:if test="${session_member_grade == 0}">
					<div class="inner">작성자:<input type="hidden" name="name" class="txt w100" value="${session_member_name }">${session_member_name}</div>
					<div class="inner">비밀번호 : <input type="password" class="txt w100" name="password" /></div>
					</c:if> 
					<c:if test="${session_member_name==null }"> 
					<div class="inner">작성자 : <input type="text" class="txt w100" name="name" ></div>
					<div class="inner">비밀번호 : <input type="password" class="txt w100" name="password" /></div>
					</c:if>
					<c:if test="${session_member_grade == 1}">
					<div class="inner">작성자:<input type="hidden" name="name" class="txt w100" value="${session_member_name }">${session_member_name}</div>
					<div class="inner">비밀번호 : <input type="hidden" class="txt w100" name="password" value="admin"/></div>
					</c:if>
				</div>
				
				<div class="reply_write">
					<div class="textarea_grp">
						<pre><textarea name="content"></textarea>
						<form:errors path="content"/>
						</pre>	
					</div>
					<span class="btn btnC_05 reply_btn">
						<input type="submit" value="입력" />
					</span>
				</div>
			</div>
			</form:form>
			
			<%-- <c:if test="commentlist.size() > 0"> --%>
				<p class="reply_num">
					댓글 수: <strong>${cmtcount}</strong>
				</p>
			<%-- </c:if> --%>
			
			<c:forEach var="commentlist" items="${commentlist }" varStatus="stat">
			<div class="reply_view">
				<div class="reply_tit">
				<input type="hidden" name="password" value="${password}"/>
					<p class="tit"><strong>${commentlist.name }</strong>님 &nbsp;&nbsp;&nbsp; 작성일 : <fmt:formatDate value="${commentlist.reg_date}" pattern="yy.MM.dd"></fmt:formatDate><span class="ip"></span></p>
					<a href="#none" onclick="openComment('<%=cp %>/magazine/checkForm.mt?mcomment_no=${commentlist.mcomment_no }&magazine_no=${magazine.magazine_no}&currentPage=${currentPage }')" class="btn btnC_01 btnP_02">
						<span>삭제</span>
					</a>
				</div>
				<div class="reply_cts">
					<p>${commentlist.content }</p>
				</div>
			</div>
			</c:forEach>
		</div><!-- // reply_grp -->
		<div class="paging">
			${pagingHtml2 }
		</div>
		
		<div class="btn_type_03">
			<a href="magazineList.mt" class="btn btnC_03 btnP_04 mr10" >
				<span>목록</span>
			</a>
			<c:if test="${session_member_grade == 1}">
			<a href="/project/admin/adminMagazineUpdateForm.mt?magazine_no=${magazine.magazine_no }" class="btn btnC_03 btnP_04 mr10">
				<span>수정</span>
			</a>
			<a href="#none" class="btn btnC_03 btnP_04 mr10" onclick="del_check('/project/admin/adminMagazineDelete.mt?magazine_no=${magazine.magazine_no}')">
				<span>삭제</span>
			</a>
			</c:if>
		</div>
	</div>


