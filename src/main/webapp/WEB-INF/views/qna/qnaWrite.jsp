<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% String cp = request.getContextPath(); %>
<div class="terms_grp">
	<div class="terms_list">
		<ul>
			<li><a href="<%= cp %>/notice/noticeList.mt">공지사항</a></li>
			<li class="on"><a href="<%= cp %>/qna/qnaList.mt">Q&amp;A</a></li>
			<li><a href="<%= cp %>/common/accessterms.mt">이용약관</a></li>
			<li><a href="<%= cp %>/common/privacy.mt">개인정보취급방침</a></li>
		</ul>
	</div>
	<div class="terms_ct">
		<h3 class="sub_tit">Q&A Write</h3>
		<form action="#none" method="post">
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
							<td><input type="text" class="txt w100" name="name" /></td>
						</tr>
						<tr>
							<th scope="row">비밀번호</th>
							<td><input type="text" class="txt w100" name="passwd" /></td>
						</tr>
						<tr>
							<th scope="row">제목</th>
							<td><input type="text" class="txt" name="subject" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="content"></textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<a href="<%=cp %>/qna/qnaList.mt" class="btn btnC_03 btnP_04 mr10">
					<span>취소</span>
				</a> <span class="btn btnC_04 btnP_04"> <input type="submit"
					value="작성" />
				</span>
			</div>
		</form>
	</div>
</div>