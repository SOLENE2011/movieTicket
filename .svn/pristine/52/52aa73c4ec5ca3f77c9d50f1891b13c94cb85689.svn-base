<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="terms_ct">
		<h3 class="sub_tit">공지사항 수정</h3>
		<form action="noticeModify.mt" method="post">
			<input type="hidden" name="no" value="${noticeModel.no}" /> <input
				type="hidden" name="currentPage" value="${currentPage}" />
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
							<td>${session_member_name}<input type="hidden" name="name"
								value="${session_member_name}" />
							</td>
						</tr>
						<tr>
							<th scope="row">글제목</th>
							<td><input class="txt w200" name="subject"
								value="${noticeModel.subject}" /> <font color="red"><form:errors
										path="subject" /></font></td>
						</tr>
						<tr>
							<th scope="row">글내용</th>
							<td>
								<div class="textarea_grp">
									<textarea name="contents">${noticeModel.contents}</textarea>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_type_03">
				<span class="btn btnC_03 btnP_04 mr10" onclick="history.go(-1);">
					<input type="button" value="취소" />
				</span> <span class="btn btnC_04 btnP_04"> <input type="submit"
					value="수정완료" />
				</span>
			</div>
		</form>
	</div>
</body>
</html>