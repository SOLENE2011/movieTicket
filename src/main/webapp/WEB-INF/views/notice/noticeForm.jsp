<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="container">
	<div class="terms_grp">
		<div class="terms_list">
			<ul>
				<li class="on"><a href="notice.html">공지사항</a></li>
				<li><a href="faq.html">FAQ</a></li>
				<li><a href="terms_01.html">이용약관</a></li>
				<li><a href="terms_02.html">개인정보취급방침</a></li>
			</ul>
		</div>
		<div class="terms_ct">
			<%-- <form:form commandName="noticeModel" action="noticeWrite.mt" method="post"> --%>
			<form action="noticeWrite.mt" method="post">
				<div class="tbl_type_01">
					<table>
						<caption>번호,제목,글쓴이,날짜,조회를 나타내는 공지사항 표</caption>
						<colgroup>
							<col style="width: 120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">글쓴이</th>
								<td>${session_member_name } <input type="hidden"
									name="name" value="${session_member_name }">
							</tr>
							<tr>
								<th scope="row">제목</th>
								<td><input type="text" name="subject" class="txt w200"/>
										 <font color="red"><%-- <form:errors
											path="subject" /> --%> </font></td>
							</tr>
							<tr>
								<th scope="row">내용</th>
								<td>
									<div class="textarea_grp">
										<textarea name="contents" theme="simple" ></textarea>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_type_03">
					<a href="noticeList.mt" class="btn btnC_03 btnP_04 mr10"> <span>취소</span>
					</a> <span class="btn btnC_04 btnP_04"> <input type="submit"
						value="작성" />
					</span>
				</div>
				</form>

	
		<!-- paging -->
		<div class="paging">
			<a href="#none" class="page prv">&lt;</a>
			<strong>1</strong>
			<a href="#none" class="page">2</a>
			<a href="#none" class="page">3</a>
			<a href="#none" class="page">4</a>
			<a href="#none" class="page">5</a>
			<a href="#none" class="page next">&gt;</a>
		</div><!-- // paging -->
	</div>
</div>


<!-- paging -->
<!-- <div class="paging">
				<a href="#none" class="page prv">&lt;</a>
				<strong>1</strong>
				<a href="#none" class="page">2</a>
				<a href="#none" class="page">3</a>
				<a href="#none" class="page">4</a>
				<a href="#none" class="page">5</a>
				<a href="#none" class="page next">&gt;</a>
			</div>// paging -->
