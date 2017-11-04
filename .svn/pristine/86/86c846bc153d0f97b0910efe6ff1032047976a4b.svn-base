<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String cp = request.getContextPath(); %>

<script type="text/javascript">
	function noticedeletecomment(url) {
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
			location.href = url;
		}else{   //취소
		    return;
		}
	}
</script>
<script type="text/javascript">
	function noticeDelete() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			location.href = '<%=cp %>/admin/adminNoticeDelete.mt?no=${noticeModel.no}';
		} else { //취소
			return;
		}
	}
</script>
<div class="terms_grp">
	<div class="terms_list">
		<ul>
			<li class="on"><a href="<%= cp %>/notice/noticeList.mt">공지사항</a></li>
			<li><a href="<%= cp %>/qna/qnaList.mt">Q&amp;A</a></li>
			<li><a href="<%= cp %>/common/accessterms.mt">이용약관</a></li>
			<li><a href="<%= cp %>/common/privacy.mt">개인정보취급방침</a></li>
		</ul>
	</div>
	<div class="terms_ct">
		<h3 class="sub_tit">공지사항 상세보기</h3>
		<div class="tbl_type_01">
			<table>
				<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
				<colgroup>
					<col style="width: 120px;" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">작성자</th>
						<td>${noticeModel.name}</td>
					</tr>
					<tr>
						<th scope="row">글제목</th>
						<td>${noticeModel.subject}</td>
					</tr>
					<tr>
						<th scope="row">작성일</th>
						<td><fmt:formatDate value="${noticeModel.regdate}" pattern="yyyy.MM.dd" /></td>
					</tr>
					<tr>
						<th scope="row">글내용</th>
						<td><pre>${noticeModel.contents}</pre></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn_type_03">
			<a href="#none" class="btn btnC_03 btnP_04 mr10" onclick="location.href='noticeList.mt?currentPage=${currentPage}'">
				<span>목록</span>
			</a>
			<c:if test="${session_member_grade == 1 }">
				<span class="btn btnC_04 btnP_04 mr10">
					<input type="button" onclick="location.href='<%=cp %>/admin/adminNoticeModify.mt?no=${noticeModel.no}'" value="수정" />
				</span>
			</c:if>
			<c:if test="${session_member_grade == 1 }">
				<span class="btn btnC_04 btnP_04">
					<input type="button" onclick="noticeDelete()" value="삭제" />
				</span>
			</c:if> 
		</div>
	</div>
</div>
<div class="reply_grp">
			<form:form action="noticeWriteComment.mt" method="post" name="cfrms" onsubmit="return validation();">
			<div class="reply_form">
				<div class="reply_inp">
					<input type="hidden" name="no" value="${noticeModel.no}"/>
					<input type="hidden" name="currentPage" value="${currentPage}"/>
					<input type="hidden" name="currentPage2" value="${currentPage2}"/>
					<c:if test="${session_member_grade == 0}">
					<div class="inner">작성자:<input type="hidden" name="name" class="txt w100" value="${session_member_name }">${session_member_name}</div>
					</c:if> 
					<c:if test="${session_member_name==null }"> 
					<div class="inner">작성자 : <input type="text" class="txt w100" name="name" ></div>
					</c:if>
					<c:if test="${session_member_grade == 1}">
					<div class="inner">작성자:<input type="hidden" name="name" class="txt w100" value="${session_member_name }">${session_member_name}</div>
					</c:if>
				</div>
				
				<div class="reply_write">
					<div class="textarea_grp">
						<pre><textarea name="contents"></textarea>
						<form:errors path="contents"/>
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
			
			<c:forEach var="noticecomment" items="${noticecommentlist }" varStatus="stat">
			<div class="reply_view">
				<div class="reply_tit">
				<%-- <input type="hidden" name="password" value="${password}"/> --%>
					<p class="tit"><strong>${noticecomment.name }</strong>님 &nbsp;&nbsp;&nbsp; 작성일 : <fmt:formatDate value="${noticecomment.reg_date}" pattern="yyyy.MM.dd"></fmt:formatDate><span class="ip"></span></p>
					<span class="btn btnC_04 btnP_04">
						<input type="button" onclick="noticedeletecomment('<%=cp%>/notice/noticeCommentDelete.mt?noticecomment_no=${noticecomment.noticecomment_no }&no=${noticeModel.no}&currentPage=${currentPage}')" value="삭제" />
						<%-- <a href="#none" onclick="openComment('<%=cp %>/magazine/checkForm.mt?mcomment_no=${commentlist.mcomment_no }&magazine_no=${magazine.magazine_no}&currentPage=${currentPage }')" class="btn btnC_01 btnP_02"> --%>
					</span>
				</div>
				<div class="reply_cts">
					<p>${noticecomment.contents }</p>
				</div>
			</div>
			</c:forEach>
		</div><!-- // reply_grp -->
		<div class="paging">
			${pagingHtml2 }
		</div>